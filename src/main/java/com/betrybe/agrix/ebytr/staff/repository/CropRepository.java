package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * cria um repositorio para crop.
 *
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  @Query(
      value = "SELECT c.* FROM crop AS c "
          +
          "JOIN farm as f ON c.farm_id = f.id "
          +
          "WHERE harvest_date >= :start AND harvest_date <= :end",
      nativeQuery = true
  )
  List<Crop> findByDate(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
