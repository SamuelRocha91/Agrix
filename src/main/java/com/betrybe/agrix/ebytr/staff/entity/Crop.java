package com.betrybe.agrix.ebytr.staff.entity;

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
 * cria a entidade crop do banco de dados.
 *
 */
@Entity
@Table(name = "crop")
public class Crop {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  private String name;

  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  @Column(name = "planted_date")
  private LocalDate plantedDate;

  @Column(name = "harvest_date")
  private LocalDate harvestDate;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crop_id")
  )
  private List<Fertilizer> fertilizers;

  public Crop() {
  }

  /**
   * cria entidade crop do banco de dados.
   *
   * @param id um Long.
   * @param name uma string com o nome da plantacao.
   * @param plantedArea um double com a area plantada.
   * @param farm um id correspondente a fazenda.
   */
  public Crop(Long id, String name, Double plantedArea, Farm farm, LocalDate plantedDate,
      LocalDate harvestDate, List<Fertilizer> fertilizers) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.harvestDate = harvestDate;
    this.plantedDate = plantedDate;
    this.fertilizers = fertilizers;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(Fertilizer fertilizers) {
    this.fertilizers.add(fertilizers);
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea  = plantedArea;
  }
}
