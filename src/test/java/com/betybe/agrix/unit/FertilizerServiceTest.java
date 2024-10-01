package com.betybe.agrix.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.model.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.model.repository.FertilizerRepository;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = AgrixApplication.class)
@ActiveProfiles("test")
public class FertilizerServiceTest {

  @MockBean
  FertilizerRepository fertilizerRepository;

  @Autowired
  FertilizerService fertilizerService;

  private Fertilizer createDefaultFertilizer() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setBrand("ajx");
    fertilizer.setComposition("areais");
    fertilizer.setName("limoeiro");
    return fertilizer;
  }

  private Fertilizer createDefaultFertilizerWithId(Long id) {
    Fertilizer fertilizer = createDefaultFertilizer();
    fertilizer.setId(id);
    return fertilizer;
  }


  @Test
  public void testFertilizerCreation() {
    Fertilizer fertilizer = createDefaultFertilizer();

    Fertilizer fertilizer1 = createDefaultFertilizerWithId(123L);

    Mockito.when(fertilizerRepository.save(any())).thenReturn(fertilizer1);

    FertilizerDto fertilizer2 = fertilizerService.create(fertilizer);

    Mockito.verify(fertilizerRepository).save(any());

    assertEquals(123L, fertilizer2.id());
  }

  @Test
  public void testGetAllFertilizers() {
    Fertilizer fertilizer = createDefaultFertilizer();

    Fertilizer fertilizer1 = createDefaultFertilizerWithId(123L);

    Mockito.when(fertilizerRepository.findAll())
        .thenReturn(List.of(fertilizer1));

    List<FertilizerDto> fertilizer2 = fertilizerService.findAll();

    Mockito.verify(fertilizerRepository).findAll();

    assertEquals(123L, fertilizer2.get(0).id());
  }

  @Test
  public void testGeFertilizersById() {
    Fertilizer fertilizer = createDefaultFertilizer();

    Fertilizer fertilizer1 = createDefaultFertilizerWithId(123L);

    Mockito.when(fertilizerRepository.findById(123L))
        .thenReturn(Optional.of(fertilizer1));

    Fertilizer fertilizer2 = fertilizerService.findById(123L);

    Mockito.verify(fertilizerRepository).findById(123L);

    assertEquals(123L, fertilizer2.getId());
  }

  @Test
  public void testGeFertilizersByIdThrow() {
    Mockito.when(fertilizerRepository.findById(any()))
        .thenReturn(Optional.empty());

    assertThrows(FertilizerNotFoundException.class, () -> fertilizerService.findById(123L));

    Mockito.verify(fertilizerRepository).findById(eq(123L));
  }
}
