package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.ErrorMessages;
import com.betrybe.agrix.ebytr.staff.model.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository    the crop repository
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  public Crop getCropById(Long id) {
    return cropRepository.findById(id)
        .orElseThrow(() -> new CropNotFoundException(ErrorMessages.CROP_NOT_FOUND));
  }

  /**
   * Gets crop by date.
   *
   * @param start the start
   * @param end   the end
   * @return the crop by date
   */
  public List<Crop> getCropByDate(LocalDate start, LocalDate end) {
    return cropRepository.findByharvestDateBetween(start, end);
  }

  /**
   * Link crop to fertilizers.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   */
  public void linkCropToFertilizers(Long cropId, Long fertilizerId) {
    Crop crop = getCropById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);
  }

  /**
   * Gets fertilizer by crop.
   *
   * @param cropId the crop id
   * @return the fertilizer by crop
   */
  public List<Fertilizer> getFertilizerByCrop(Long cropId) {
    return getCropById(cropId).getFertilizers();
  }
}
