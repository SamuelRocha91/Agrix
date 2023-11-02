package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.CropDtoResponse;
import com.betrybe.agrix.ebytr.staff.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmDtoResponse;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cria classe controller de farm.
 *
 */
@RestController
@RequestMapping("/farms")
@Secured({"ADMIN", "USER", "MANAGER"})
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * rota de inserção de nova fazenda.
   *
   * @param farmCreationDto dto para recebimento dos dados.
   * @return a fazenda cadastrada.
   */
  @PostMapping()
  public ResponseEntity<FarmDtoResponse> insertFarm(@RequestBody FarmCreationDto farmCreationDto) {
    Farm farm = farmService.createFarm(farmCreationDto.toEntity());
    FarmDtoResponse farmDtoResponse = new FarmDtoResponse(farm.getId(),
        farm.getName(), farm.getSize());
    return ResponseEntity.status(HttpStatus.CREATED).body(farmDtoResponse);
  }

  /**
   * Rota de acesso a todas as fazendas cadastradas.
   *
   * @return uma lista de fazendas
   */
  @GetMapping
  public ResponseEntity<List<FarmDtoResponse>> getFarms() {
    List<Farm> farm = farmService.getAllFarms();
    List<FarmDtoResponse> farmDtoResponse = farm.stream().map((e)
        -> new FarmDtoResponse(e.getId(), e.getName(), e.getSize())).toList();
    return ResponseEntity.status(HttpStatus.OK).body(farmDtoResponse);
  }

  /**
   * rota de acesso as fazendas por id.
   *
   * @param id long.
   * @return a fazenda busca pelo id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDtoResponse> getFarmById(@PathVariable Long id) {
    Farm farm = farmService.findFarmById(id);
    FarmDtoResponse farmDtoResponse = new FarmDtoResponse(id, farm.getName(), farm.getSize());
    return ResponseEntity.status(HttpStatus.OK).body(farmDtoResponse);
  }

  /**
   * rota para cadastro de plantações.
   *
   * @param farmId id da fazenda a ser cadastrada.
   * @param cropDto dados da plantação.
   * @return a plantação cadastrada.
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDtoResponse> createCropByFarm(@PathVariable Long farmId,
      @RequestBody CropDto cropDto) {
    Crop crop = farmService.createCropByFarm(farmId, cropDto.toEntity());
    CropDtoResponse cropDtoResponse = new CropDtoResponse(crop.getId(),
        crop.getName(), crop.getPlantedArea(), crop.getFarm().getId(),
        crop.getPlantedDate(), crop.getHarvestDate());
    return ResponseEntity.status(HttpStatus.CREATED).body(cropDtoResponse);
  }

  /**
   * rota para receber dados de plantações de uma fazenda.
   *
   * @param farmId long, id da fazenda.
   * @return uma lista com as plantaçoes.
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDtoResponse>> getCropsByFarmId(@PathVariable Long farmId) {
    List<Crop> crop = farmService.getAllcropsByfarm(farmId);
    List<CropDtoResponse> cropDtoResponse = crop.stream().map((e) -> new CropDtoResponse(e.getId(),
        e.getName(), e.getPlantedArea(), e.getFarm().getId(),
        e.getPlantedDate(), e.getHarvestDate())).toList();
    return ResponseEntity.status(HttpStatus.OK).body(cropDtoResponse);
  }
}
