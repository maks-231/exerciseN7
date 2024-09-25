package com.microservices.countries.controller;

import com.microservices.countries.dto.CountryDto;
import com.microservices.countries.service.CountryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PutMapping("/update-country-by-name/{name}")
  public CountryDto updateCountryByName(@PathVariable("name") String name, @RequestBody CountryDto countryDto) {
    CountryDto country = null;

    try {
      country = countryService.updateCountByName(name, countryDto);
    } catch (Exception e) {
      System.out.println(e);
    }

    return country;
  }

  @PutMapping("/update-country-by-id/{id}")
  public CountryDto updateCountryById(@PathVariable("id") Long id, @RequestBody CountryDto countryDto) {
    CountryDto country = null;

    try {
      country = countryService.updateCountryById(id, countryDto);
    } catch (Exception e) {
      System.out.println(e);
    }

    return country;
  }
}
