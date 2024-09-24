package com.microservices.countries.service;

import com.microservices.countries.dto.CityDto;
import com.microservices.countries.entity.CityEntity;
import com.microservices.countries.repository.CityRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import jakarta.annotation.Resource;

@Service
public class CityService {
  @Resource
  private CityRepository cityRepository;

  @Value("${spring.application.name}")
  private String appName;

  @Value("${server.port}")
  private String port;

  public List<CityDto> getAllCities() {
    ModelMapper mapper = new ModelMapper();

    return cityRepository.findAll().stream()
        .map(entity -> mapper.map(entity, CityDto.class))
        .map(cityDto -> {
          cityDto.setPort(port);
          cityDto.setAppName(appName);
          return cityDto;
        })
        .toList();
  }

  public CityDto getCityByName(@PathVariable("name") String name) {
    ModelMapper mapper = new ModelMapper();

    CityEntity city = cityRepository.findByName(name);
    CityDto cityDto = mapper.map(city, CityDto.class);
    cityDto.setPort(port);
    cityDto.setAppName(appName);

    return cityDto;
  }
}
