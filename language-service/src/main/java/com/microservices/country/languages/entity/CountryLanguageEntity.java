package com.microservices.country.languages.entity;

import com.microservices.country.languages.enums.IsOfficial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "countrylanguage")
public class CountryLanguageEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="countrycode")
  private String countryCode;

  @Column(name="language")
  private String language;

  @Enumerated(EnumType.STRING)
  @Column(name = "isofficial")
  private IsOfficial isOfficial;

  @Column(name = "percentage")
  private Float percentage;

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
