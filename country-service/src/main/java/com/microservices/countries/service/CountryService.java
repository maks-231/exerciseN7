package com.microservices.countries.service;

import com.microservices.countries.dto.CountryDto;
import com.microservices.countries.entity.CountryEntity;
import com.microservices.countries.repository.CountryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


  public CountryEntity getCountryEntityByName(@PathVariable("name") String name) {
    return countryRepository.findByName(name);
  }

  public CountryDto getCountryByName(@PathVariable("name") String name) {
    ModelMapper mapper = new ModelMapper();

    CountryEntity country = countryRepository.findByName(name);
    CountryDto countryDto = mapper.map(country, CountryDto.class);
    countryDto.setPort(port);
    countryDto.setAppName(appName);

    return countryDto;
  }

  public CountryEntity getCountryEntityById(Long id) throws Exception {
    Optional<CountryEntity> country = countryRepository.findById(id);
    if(!country.isPresent()){
      throw new Exception("Country not found");
    }

    return country.get();
  }

  public CountryDto getCountryDtoById(Long id) {
    ModelMapper mapper = new ModelMapper();

    CountryEntity country = null;

    try {
      country = getCountryEntityById(id);
    } catch (Exception e) {
      System.out.println(e);
    }

    CountryDto countryDto = mapper.map(country, CountryDto.class);
    countryDto.setPort(port);
    countryDto.setAppName(appName);

    return countryDto;
  }

  public CountryDto updateCountByName(String name, CountryDto countryDto) throws Exception  {
    CountryEntity country = getCountryEntityByName(name);
    return updateCountry(country, countryDto);
  }

  public CountryDto updateCountryById(Long id, CountryDto countryDto) throws Exception  {
    CountryEntity country = getCountryEntityById(id);
    return updateCountry(country, countryDto);
  }

  private CountryDto updateCountry(CountryEntity country, CountryDto countryDto) throws Exception {
    if(ObjectUtils.isEmpty(country)) {
      throw new Exception("Country not found");
    }

    if(ObjectUtils.isEmpty(countryDto)) {
      throw new Exception("Nothing to update");
    }

    if(!Objects.isNull(countryDto.getHeadOfState()) && !countryDto.getHeadOfState().trim().equals(country.getHeadOfState().trim())) {
      country.setHeadOfState(countryDto.getHeadOfState());
    }

    if(!Objects.isNull(countryDto.getPopulation()) && countryDto.getPopulation() != country.getPopulation()) {
      country.setPopulation(countryDto.getPopulation());
    }

    ModelMapper mapper = new ModelMapper();
    CountryDto countryDto1 = mapper.map(countryRepository.save(country), CountryDto.class);

    countryDto1.setPort(port);
    countryDto1.setAppName(appName);

    return countryDto1;
  }
}
