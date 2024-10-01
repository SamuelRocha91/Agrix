package com.betybe.agrix.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.AgrixApplication;
import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.model.entity.Crop;
import com.betrybe.agrix.ebytr.staff.model.entity.Farm;
import com.betrybe.agrix.ebytr.staff.model.entity.Person;
import com.betrybe.agrix.ebytr.staff.model.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.model.repository.FarmRepository;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
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
public class FarmServiceTest {
  @MockBean
  FarmRepository farmRepository;

  @MockBean
  CropRepository cropRepository;

  @Autowired
  FarmService farmService;

  private Farm createDefaultFarm() {
    Farm farm = new Farm();
    farm.setName("Manaím");
    farm.setSize(77.7);
    return farm;
  }

  private Farm createDefaultFarmWithId(Long id) {
    Farm farm = createDefaultFarm();
    farm.setId(id);
    return farm;
  }

  @Test
  public void testFarmCreation() {
    Farm farm = createDefaultFarm();

    Farm farmToReturn = createDefaultFarmWithId(123L);

    Mockito.when(farmRepository.save(any())).thenReturn(farmToReturn);

    FarmDto farm1 = farmService.saveFarm(farm);

    Mockito.verify(farmRepository).save(any());

    assertEquals(farm.getName(), farm1.name());
    assertEquals(farm.getId(), farm1.id());
  }

  @Test
  public void testGetAllFarms() {
    Farm farm = createDefaultFarm();

    Farm farmToReturn = createDefaultFarmWithId(123L);

    Mockito.when(farmRepository.findAll()).thenReturn(List.of(farmToReturn));

    List<FarmDto> farms = farmService.getAllFarms();
    Mockito.verify(farmRepository).findAll();

    assertEquals(1, farms.size());
    assertEquals(farmToReturn.getId(), farms.get(0).id());
  }

  @Test
  public void testGetFarmById() {
    Farm farm = createDefaultFarm();

    Farm farmToReturn = createDefaultFarmWithId(123L);

    Mockito.when(farmRepository.findById(eq(123L))).thenReturn(Optional.ofNullable(farmToReturn));

    Farm farm1 = farmService.getFarm(123L);
    Mockito.verify(farmRepository).findById(eq(123L));

    assertEquals(farmToReturn.getName(), farm1.getName());
  }

  @Test
  public void testFarmNotFound() {
    Mockito.when(farmRepository.findById(any()))
        .thenReturn(Optional.empty());

    assertThrows(FarmNotFoundException.class, () -> farmService.getFarm(123L));

    Mockito.verify(farmRepository).findById(eq(123L));
  }

  @Test
  public void testCreateFarmByCrop() {
    Farm farm = createDefaultFarm();

    Farm farmToReturn = createDefaultFarmWithId(123L);

    Crop crop = new Crop();
    crop.setFarm(farmToReturn);
    Mockito.when(farmRepository.findById(any())).thenReturn(Optional.of(farmToReturn));
    Mockito.when(cropRepository.save(any())).thenReturn(crop);

    Crop crop1 = farmService.createFarmCrop(123L, crop);
    Mockito.verify(cropRepository).save(eq(crop));

    assertEquals(farmToReturn.getId(), crop1.getFarm().getId());
  }

}
