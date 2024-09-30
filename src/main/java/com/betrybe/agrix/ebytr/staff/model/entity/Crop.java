package com.betrybe.agrix.ebytr.staff.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Crop.
 */
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;
  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  @Column(name = "planted_date")
  private LocalDate plantedDate;

  @Column(name = "harvest_date")

  private LocalDate harvestDate;

  /**
   * Gets fertilizers.
   *
   * @return the fertilizers
   */
  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  /**
   * Sets fertilizers.
   *
   * @param fertilizers the fertilizers
   */
  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }

  /**
   * The Fertilizers.
   */
  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  List<Fertilizer> fertilizers;


  /**
   * Instantiates a new Crop.
   */
  public Crop() {
  }

  /**
   * Instantiates a new Crop.
   *
   * @param name        the name
   * @param plantedArea the planted area
   */
  public Crop(
      String name,
      Double plantedArea,
      LocalDate plantedDate,
      LocalDate harvestDate
  ) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.harvestDate = harvestDate;
    this.plantedDate = plantedDate;
  }


  /**
   * Gets planted date.
   *
   * @return the planted date
   */
  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  /**
   * Sets planted date.
   *
   * @param plantedDate the planted date
   */
  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  /**
   * Gets planted area.
   *
   * @return the planted area
   */
  public Double getPlantedArea() {
    return plantedArea;
  }

  /**
   * Sets planted area.
   *
   * @param plantedArea the planted area
   */
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Gets havest date.
   *
   * @return the havest date
   */
  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  /**
   * Sets havest date.
   *
   * @param harvestDate the havest date
   */
  public void setHavestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }


  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets planted area.
   *
   * @return the planted area
   */
  public Double getPlanted_area() {
    return plantedArea;
  }

  /**
   * Sets planted area.
   *
   * @param plantedArea the planted area
   */
  public void setPlanted_area(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Gets farm.
   *
   * @return the farm
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Sets farm.
   *
   * @param farm the farm
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
