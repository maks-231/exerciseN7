package com.microservices.countries.dto;

import com.microservices.countries.enums.Continent;

import java.time.LocalDate;


public class CountryDto {
  private Long id;
  private String country;
  private String name;
  private Continent continent;
  private String region;
  private Float surfaceArea;
  private LocalDate indepYear;
  private Integer population;
  private Float lifeExpectancy;
  private Float gnp;
  private Float gnpoId;
  private String localName;
  private String governmentForm;
  private String headOfState;
  private String capital;
  private String code2;

  private String port;

  private String appName;

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Continent getContinent() {
    return continent;
  }

  public void setContinent(Continent continent) {
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

  public LocalDate getIndepYear() {
    return indepYear;
  }

  public void setIndepYear(LocalDate indepYear) {
    this.indepYear = indepYear;
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

  public Float getGnpoId() {
    return gnpoId;
  }

  public void setGnpoId(Float gnpoId) {
    this.gnpoId = gnpoId;
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
