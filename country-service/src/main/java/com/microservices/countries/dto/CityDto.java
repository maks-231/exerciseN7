package com.microservices.countries.dto;


public class CityDto {
  private Long id;
  private String name;
  private String countryCode;
  private String district;
  private Integer population;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }
}
