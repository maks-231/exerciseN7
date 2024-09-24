package com.microservices.countries.service;

import com.microservices.countries.dto.CountryDto;
import com.microservices.countries.entity.CountryEntity;
import com.microservices.countries.repository.CountryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import jakarta.annotation.Resource;

@Service
public class CountryService {
  @Resource
  private CountryRepository countryRepository;

  @Value("${spring.application.name}")
  private String appName;

  @Value("${server.port}")
  private String port;

  public List<CountryDto> getAllCountries() {
    ModelMapper mapper = new ModelMapper();

    return countryRepository.findAll().stream()
        .map(entity -> mapper.map(entity, CountryDto.class))
        .map(countryDto -> {
          countryDto.setPort(port);
          countryDto.setAppName(appName);
          return countryDto;
        })
        .toList();
  }


  public CountryDto getCountryByName(@PathVariable("name") String name) {
    ModelMapper mapper = new ModelMapper();

    CountryEntity country = countryRepository.findByName(name);
    CountryDto countryDto = mapper.map(country, CountryDto.class);
    countryDto.setPort(port);
    countryDto.setAppName(appName);

    return countryDto;
  }
}
