package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.exception.ErrorMessages;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import com.betrybe.agrix.ebytr.staff.model.entity.Farm;
import com.betrybe.agrix.ebytr.staff.model.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.model.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param repository     the repository
   * @param cropRepository the crop repository
   */
  @Autowired
  public FarmService(FarmRepository repository, CropRepository cropRepository) {
    this.farmRepository = repository;
    this.cropRepository = cropRepository;
  }

  /**
   * Save farm farm dto.
   *
   * @param farm the farm
   * @return the farm dto
   */
  public FarmDto saveFarm(Farm farm) {
    Farm farmSaved = farmRepository.save(farm);
    return FarmDto.entityFromDto(farm);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  public List<FarmDto> getAllFarms() {
    return farmRepository.findAll()
        .stream().map(FarmDto::entityFromDto).toList();
  }

  /**
   * Gets farm.
   *
   * @param id the id
   * @return the farm
   */
  public Farm getFarm(Long id) {
    return farmRepository.findById(id)
        .orElseThrow(() -> new FarmNotFoundException(ErrorMessages.FARM_NOT_FOUND));
  }

  /**
   * Create farm crop crop.
   *
   * @param id   the id
   * @param crop the crop
   * @return the crop
   */
  public Crop createFarmCrop(Long id, Crop crop) {
    Farm farm = getFarm(id);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

}