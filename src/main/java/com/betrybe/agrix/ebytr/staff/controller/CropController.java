package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDtoResponse;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cria a controller da rota "/crops".
 *
 */
@RestController
@RequestMapping("/crops")
@Secured({"ADMIN", "MANAGER"})
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropsService) {
    this.cropService = cropsService;
  }

  /**
   * cria rota get crops.
   *
   * @return retorna uma lista de crops.
   */
  @GetMapping
  public ResponseEntity<List<CropDtoResponse>> getAllCrops() {
    List<CropDtoResponse> crop = cropService.findAll().stream().map((e) ->
        new CropDtoResponse(e.getId(),
        e.getName(), e.getPlantedArea(), e.getFarm().getId(),
            e.getPlantedDate(), e.getHarvestDate())).toList();
    return ResponseEntity.status(HttpStatus.OK).body(crop);
  }

  /**
   * cria rota para verificar uma plantação específica.
   *
   * @return uma plantação específica.
   */

  @GetMapping("/{id}")
  public ResponseEntity<CropDtoResponse> getCropById(@PathVariable Long id) {
    Crop crop = cropService.findById(id);
    CropDtoResponse cropDtoResponse = new CropDtoResponse(crop.getId(),
        crop.getName(), crop.getPlantedArea(), crop.getFarm().getId(), crop.getPlantedDate(),
        crop.getHarvestDate());
    return ResponseEntity.status(HttpStatus.OK).body(cropDtoResponse);
  }

  /**
   * cria possibilidade de retorno de dados por data da plantação.
   *
   * @param start LocalDate.
   * @param end LocalDAte.
   * @return uma response.
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDtoResponse>> getCropByDate(@RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    List<CropDtoResponse> crop = cropService.findByDate(start, end).stream().map((e) ->
        new CropDtoResponse(e.getId(),
            e.getName(), e.getPlantedArea(), e.getFarm().getId(),
            e.getPlantedDate(), e.getHarvestDate())).toList();
    return ResponseEntity.status(HttpStatus.OK).body(crop);
  }

  /**
   * cria rota post para vincular um fertilizante a uma plantacao.
   *
   * @param cropId Long.
   * @param fertilizerId Long.
   * @return uma confirmação.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateCropAndFertilizer(@PathVariable
      Long cropId, @PathVariable Long fertilizerId) {
    cropService.associateCropAndFertilizer(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED).body("Fertilizante e plantação "
        + "associados com sucesso!");
  }

  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<Fertilizer>> getFertilizerAssociatedCropById(@PathVariable
      Long cropId) {
    List<Fertilizer> fertilizers = cropService.findFertilizersByCrop(cropId);
    return ResponseEntity.status(HttpStatus.OK).body(fertilizers);
  }
}
