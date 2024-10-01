package com.betybe.agrix.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import com.betrybe.agrix.ebytr.staff.model.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.model.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
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

  @Test
  public void testGetCropById() {
    Crop crop = createDefaultCrop();

    Crop cropToReturn = createDefaultCropWithId(123L);

    Mockito.when(cropRepository.findById(eq(123L)))
        .thenReturn(Optional.of(cropToReturn));

    Crop crop1 = cropService.getCropById(123L);

    Mockito.verify(cropRepository).findById(eq(123L));

    assertEquals(123L, crop1.getId());
    assertEquals(crop.getPlantedArea(), crop1.getPlantedArea());
  }

  @Test
  public void testThrowGetCropById() {
    Mockito.when(cropRepository.findById(any()))
        .thenReturn(Optional.empty());

    assertThrows(CropNotFoundException.class, () -> cropService.getCropById(123L));

    Mockito.verify(cropRepository).findById(eq(123L));
  }

  @Test
  public void testGetCropByDate() {
    Crop crop = createDefaultCrop();

    List<Crop> cropToReturn = List.of(createDefaultCropWithId(123L));

    Mockito.when(cropRepository
            .findByharvestDateBetween(eq(LocalDate.parse("2023-01-04")),
                eq(LocalDate.parse("2023-05-12"))))
        .thenReturn(cropToReturn);

    List<Crop> crop1 = cropService
        .getCropByDate(LocalDate.parse("2023-01-04"),
    LocalDate.parse("2023-05-12"));

    Mockito.verify(cropRepository)
        .findByharvestDateBetween(eq(LocalDate.parse("2023-01-04")),
        eq(LocalDate.parse("2023-05-12")));

    assertEquals(1, crop1.size());
    assertEquals(crop.getPlantedArea(), crop1.get(0).getPlantedArea());
  }

  @Test
  public void testgetFertilizersByCrop() {
    Crop cropToReturn = createDefaultCropWithId(123L);
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName("Humus");
    fertilizer.setComposition("terra");
    fertilizer.setBrand("ajk");
    cropToReturn.setFertilizers(List.of(fertilizer));

    Mockito.when(cropRepository.findById(any())).thenReturn(Optional.of(cropToReturn));

    List<Fertilizer> fertilizer1 = cropService.getFertilizerByCrop(123L);

    Mockito.verify(cropRepository).findById(eq(123L));

    assertEquals(1, fertilizer1.size());
    assertEquals("Humus", fertilizer1.get(0).getName());
  }
}
