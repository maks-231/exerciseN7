package com.microservices.countries.controller;

import com.microservices.countries.dto.CityDto;
import com.microservices.countries.service.CityService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/city")
public class CityController {
  @Resource
  private CityService cityService;

  @GetMapping("/all-cities")
  public List<CityDto> getAllCities() {
    return cityService.getAllCities();
  }

  @GetMapping("/city-by-name/{name}")
  public CityDto getCityByName(@PathVariable("name") String name) {
    return cityService.getCityDtoByName(name);
  }

  @PutMapping("/update-city-by-name/{name}")
  public CityDto updateCityByName(@PathVariable("name") String name, @RequestBody CityDto cityDto) {
    CityDto city = null;

    try {
      city = cityService.updateCityByName(name, cityDto);
    } catch (Exception e) {
      System.out.println(e);
    }

    return city;
  }

  @PutMapping("/update-city-by-id/{id}")
  public CityDto updateCityById(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
    CityDto city = null;

    try {
      city = cityService.updateCityById(id, cityDto);
    } catch (Exception e) {
      System.out.println(e);
    }

    return city;
  }
}
