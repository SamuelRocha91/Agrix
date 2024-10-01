package com.betybe.agrix.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import com.betrybe.agrix.ebytr.staff.model.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = AgrixApplication.class)
@ActiveProfiles("test")
public class CropServiceTest {

  @MockBean
  CropRepository cropRepository;

  @Autowired
  CropService cropService;

  private Crop createDefaultCrop() {
    Crop crop = new Crop();
    crop.setName("arroz");
    crop.setPlanted_area(2.23);
    crop.setPlantedDate(LocalDate.parse("2023-06-25"));
    crop.setHavestDate(LocalDate.parse("2023-04-02"));
    return crop;
  }

  private Crop createDefaultCropWithId(Long id) {
    Crop crop = createDefaultCrop();
    crop.setId(id);
    return crop;
  }

  @Test
  public void testgetAllCrops() {
    Crop crop = createDefaultCrop();

    Crop cropToReturn = createDefaultCropWithId(123L);

    Mockito.when(cropRepository.findAll()).thenReturn(List.of(cropToReturn));

    List<Crop> crop1 = cropService.getAllCrops();

    Mockito.verify(cropRepository).findAll();

    assertEquals(1, crop1.size());
    assertEquals(123L, crop1.get(0).getId());
  }

}
