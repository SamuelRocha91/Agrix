package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.ErrorMessages;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param repository the repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository repository) {
    this.fertilizerRepository = repository;
  }

  /**
   * Create fertilizer dto.
   *
   * @param fertilizer the fertilizer
   * @return the fertilizer dto
   */
  public FertilizerDto create(Fertilizer fertilizer) {
    Fertilizer fertilizer1 = fertilizerRepository.save(fertilizer);
    return new FertilizerDto(
        fertilizer1.getId(),
        fertilizer1.getName(),
        fertilizer1.getBrand(),
        fertilizer1.getComposition()
    );
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizer1 = fertilizerRepository.findAll();
    return fertilizer1.stream().map(FertilizerDto::entityFromDto).toList();
  }

  /**
   * Find by id fertilizer.
   *
   * @param id the id
   * @return the fertilizer
   */
  public Fertilizer findById(Long id) {
    return fertilizerRepository.findById(id).orElseThrow(() -> new FertilizerNotFoundException(
        ErrorMessages.FERTILIZER_NOT_FOUND));
  }
}
