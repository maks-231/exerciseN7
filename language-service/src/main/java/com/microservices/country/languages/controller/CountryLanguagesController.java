package com.microservices.country.languages.controller;

import com.microservices.country.languages.dto.CountryLanguageDto;
import com.microservices.country.languages.service.CountryLanguagesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/language-details")
public class CountryLanguagesController {
  @Resource
  private CountryLanguagesService countryLanguagesService;

  @GetMapping("/all-languages")
  public List<CountryLanguageDto> getAllLanguages() {
    return countryLanguagesService.findAll();
  }

  @GetMapping("/all-by-country-code/{countryCode}")
  public List<CountryLanguageDto> getAllByCountryCode(@PathVariable("countryCode") String countryCode) {
    return countryLanguagesService.findAllByCountryCode(countryCode);
  }

  @GetMapping("/all-by-language/{language}")
  public List<CountryLanguageDto> getAllByLanguage(@PathVariable("language") String language) {
    return countryLanguagesService.findAllByLanguage(language);
  }
}
