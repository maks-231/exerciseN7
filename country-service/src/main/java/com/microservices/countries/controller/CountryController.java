package com.microservices.countries.controller;

import com.microservices.countries.dto.CountryDto;
import com.microservices.countries.service.CountryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/country")
public class CountryController {
  @Resource
  private CountryService countryService;

  @GetMapping("/all-countries")
  public List<CountryDto> getAllCountries() {
    return countryService.getAllCountries();
  }

  @GetMapping("/country-by-name/{name}")
  public CountryDto getCountryByName(@PathVariable("name") String name) {
    return countryService.getCountryByName(name);
  }
}
