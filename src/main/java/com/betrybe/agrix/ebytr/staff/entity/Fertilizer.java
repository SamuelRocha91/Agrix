package com.betrybe.agrix.ebytr.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * cria entidade responsável por armazenar os fertilizantes.
 *
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  private String name;

  private String brand;

  private String composition;

  @ManyToMany(mappedBy = "fertilizers")
  @JsonIgnore
  private List<Crop> cropList;

  public Fertilizer() {
  }

  /**
   * cria atributos da entidade Fertilizier.
   *
   * @param id Long.
   * @param name String.
   * @param brand String.
   * @param composition String.
   * @param cropList ListCrops.
   */
  public Fertilizer(Long id, String name, String brand, String composition, List<Crop> cropList) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
    this.cropList = cropList;
  }

  public List<Crop> getCropList() {
    return cropList;
  }

  public void setCropList(List<Crop> cropList) {
    this.cropList = cropList;
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

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }
}
