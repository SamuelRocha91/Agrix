package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service de crops.
 *
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropRepository = cropRepository;
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * recupera uma plantação por id ou lnaça erro por inexistencia.
   *
   * @param id identificador da plantação.
   * @return uma plantação específica.
   */
  public Crop findById(Long id) {
    Optional<Crop> crop = cropRepository.findById(id);
    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }
    return crop.get();
  }

  public List<Crop> findByDate(LocalDate start, LocalDate end) {
    return cropRepository.findByDate(start, end);
  }

  /**
   * Associa uma plantação a um fertilizante.
   *
   * @param cropId Long.
   * @param fertilizerId Long.
   */

  public void associateCropAndFertilizer(Long cropId, Long fertilizerId) {
    Optional<Crop> crop = cropRepository.findById(cropId);
    if (crop.isEmpty()) {
      throw new CropNotFoundException();
    }
    Optional<Fertilizer> fertilizer = fertilizerRepository.findById(fertilizerId);
    if (fertilizer.isEmpty()) {
      throw new FertilizerNotFoundException();
    }
    Crop cropOne = crop.get();
    Fertilizer fertilizerOne = fertilizer.get();

    cropOne.setFertilizers(fertilizerOne);
    cropRepository.save(cropOne);
  }

  /**
   * Busca a plantação pelo id e retorn os fertilizantes.
   *
   * @param cropId Long.
   * @return Lista de fertilizers.
   */
  public List<Fertilizer> findFertilizersByCrop(Long cropId) {
    Crop crop = this.findById(cropId);
    return crop.getFertilizers();
  }
}
