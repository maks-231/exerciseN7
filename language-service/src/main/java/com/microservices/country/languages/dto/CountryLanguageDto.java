package com.microservices.country.languages.dto;

import com.microservices.country.languages.enums.IsOfficial;

public class CountryLanguageDto {
  private Long id;
  private String countryCode;
  private String language;
  private IsOfficial isOfficial;
  private Float percentage;

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

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public IsOfficial getIsOfficial() {
    return isOfficial;
  }

  public void setIsOfficial(IsOfficial isOfficial) {
    this.isOfficial = isOfficial;
  }

  public Float getPercentage() {
    return percentage;
  }

  public void setPercentage(Float percentage) {
    this.percentage = percentage;
  }
}
