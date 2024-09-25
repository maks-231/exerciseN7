package com.microservices.countries.service;

import com.microservices.countries.dto.CityDto;
import com.microservices.countries.entity.CityEntity;
import com.microservices.countries.repository.CityRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

  public CityEntity getCityEntityByName(String name) {
    return cityRepository.findByName(name);
  }

  public CityDto getCityDtoByName(String name) {
    ModelMapper mapper = new ModelMapper();

    CityEntity city = getCityEntityByName(name);
    CityDto cityDto = mapper.map(city, CityDto.class);
    cityDto.setPort(port);
    cityDto.setAppName(appName);

    return cityDto;
  }

  public CityEntity getCityEntityById(Long id) throws Exception {
    Optional<CityEntity> city = cityRepository.findById(id);
    if(!city.isPresent()){
      throw new Exception("City not found");
    }

    return city.get();
  }

  public CityDto getCityDtoById(Long id) {
    ModelMapper mapper = new ModelMapper();

    CityEntity city = null;

    try {
      city = getCityEntityById(id);
    } catch (Exception e) {
      System.out.println(e);
    }

    CityDto cityDto = mapper.map(city, CityDto.class);
    cityDto.setPort(port);
    cityDto.setAppName(appName);

    return cityDto;
  }

  public CityDto updateCityByName(String name, CityDto cityDto) throws Exception  {
    CityEntity city = getCityEntityByName(name);
    return updateCity( city, cityDto);
  }

  public CityDto updateCityById(Long id, CityDto cityDto) throws Exception  {
    CityEntity city = getCityEntityById(id);
    return updateCity( city, cityDto);
  }

  private CityDto updateCity(CityEntity city, CityDto cityDto) throws Exception {
    if(ObjectUtils.isEmpty(city)) {
      throw new Exception("City not found");
    }

    if(ObjectUtils.isEmpty(cityDto)) {
      throw new Exception("Nothing to update");
    }

    if(!Objects.isNull(cityDto.getPopulation()) && cityDto.getPopulation() != city.getPopulation()) {
      city.setPopulation(cityDto.getPopulation());
    }

    ModelMapper mapper = new ModelMapper();
    CityDto cityDto1 = mapper.map(cityRepository.save(city), CityDto.class);

    cityDto1.setPort(port);
    cityDto1.setAppName(appName);

    return cityDto1;
  }
}
