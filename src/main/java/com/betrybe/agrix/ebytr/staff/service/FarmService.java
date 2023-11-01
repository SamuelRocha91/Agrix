package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cria a camada service de farm.
 *
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }


  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * encontra fazendas pelo id.
   *
   * @param id recebe um id long.
   * @return um erro em caso de nao ser encontrada ou a propria fazenda.
   */
  public Farm findFarmById(Long id) {
    Optional<Farm> farm = farmRepository.findById(id);
    if (farm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    return farm.get();
  }

  /**
   * cria crop por fazenda.
   *
   * @param farmId long de uma fazenda.
   * @param crop dados da plantação.
   * @return a plantação cadastrada ou lança erro.
   */
  public Crop createCropByFarm(Long farmId, Crop crop) {
    Optional<Farm> findFarm = farmRepository.findById(farmId);
    if (findFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    Farm farm = findFarm.get();
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

  /**
   * busca a existência do cadstro da fazenda. Lança erro ou retorna suas plantações.
   *
   * @param farmId id long da fazenda.
   * @return a lista ou lança o erro.
   */
  public List<Crop> getAllcropsByfarm(Long farmId) {
    Optional<Farm> findFarm = farmRepository.findById(farmId);
    if (findFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    List<Crop> crop = findFarm.get().getCrops();
    return crop;
  }
}
