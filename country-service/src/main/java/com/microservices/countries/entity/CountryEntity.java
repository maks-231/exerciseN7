package com.microservices.countries.entity;

import com.microservices.countries.enums.Continent;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "country")
public class CountryEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name = "continent")
  private String continent;

  @Column(name="region")
  private String region;

  @Column(name = "surfacearea")
  private Float surfaceArea;

  @Column(name = "indepyear")
  private Integer indepyear;

  @Column(name = "population")
  private Integer population;

  @Column(name = "lifeexpectancy")
  private Float lifeExpectancy;

  @Column(name = "gnp")
  private Float gnp;

  @Column(name = "gnpold")
  private Float gnpold;

  @Column(name="localname")
  private String localName;

  @Column(name="governmentform")
  private String governmentForm;

  @Column(name="headofstate")
  private String headOfState;

  @Column(name="capital")
  private String capital;

  @Column(name="code2")
  private String code2;

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

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Float getSurfaceArea() {
    return surfaceArea;
  }

  public void setSurfaceArea(Float surfaceArea) {
    this.surfaceArea = surfaceArea;
  }

  public Integer getIndepyear() {
    return indepyear;
  }

  public void setIndepyear(Integer indepyear) {
    this.indepyear = indepyear;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Float getLifeExpectancy() {
    return lifeExpectancy;
  }

  public void setLifeExpectancy(Float lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }

  public Float getGnp() {
    return gnp;
  }

  public void setGnp(Float gnp) {
    this.gnp = gnp;
  }

  public Float getGnpold() {
    return gnpold;
  }

  public void setGnpold(Float gnpold) {
    this.gnpold = gnpold;
  }

  public String getLocalName() {
    return localName;
  }

  public void setLocalName(String localName) {
    this.localName = localName;
  }

  public String getGovernmentForm() {
    return governmentForm;
  }

  public void setGovernmentForm(String governmentForm) {
    this.governmentForm = governmentForm;
  }

  public String getHeadOfState() {
    return headOfState;
  }

  public void setHeadOfState(String headOfState) {
    this.headOfState = headOfState;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getCode2() {
    return code2;
  }

  public void setCode2(String code2) {
    this.code2 = code2;
  }
}
