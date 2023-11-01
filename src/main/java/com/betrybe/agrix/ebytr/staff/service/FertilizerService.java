package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cria camada service de Fertilizer.
 *
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public Fertilizer createNewFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> findAllFertilizer() {
    return fertilizerRepository.findAll();
  }

  /**
   * retorna um optional com ou sem o fertilizante.
   *
   * @param id Long.
   * @return um fertilizante ou lança uma exceção.
   */
  public Fertilizer findById(Long id) {
    Optional<Fertilizer> fertilizer = fertilizerRepository.findById(id);
    if (fertilizer.isEmpty()) {
      throw new FertilizerNotFoundException();
    }
    return fertilizer.get();
  }
}
