package com.microservices.country.languages.service;

import com.microservices.country.languages.controller.CountryLanguagesController;
import com.microservices.country.languages.dto.CountryLanguageDto;
import com.microservices.country.languages.repository.CountryLanguagesRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.annotation.Resource;

@Service
public class CountryLanguagesService {
  @Value("${spring.application.name}")
  private String appName;

  @Value("${server.port}")
  private String port;

  private static final Logger LOG = LoggerFactory.getLogger(CountryLanguagesController.class);

  @Resource
  private CountryLanguagesRepository countryLanguagesRepository;
  public List<CountryLanguageDto> findAll() {
    ModelMapper mapper = new ModelMapper();

    return countryLanguagesRepository.findAll()
        .stream()
        .map(entity -> mapper.map(entity, CountryLanguageDto.class))
        .map(countryLanguageDto -> {
          countryLanguageDto.setPort(port);
          countryLanguageDto.setAppName(appName);
          return countryLanguageDto;
        })
        .toList();
  }

  public List<CountryLanguageDto> findAllByCountryCode(String countryCode) {
    ModelMapper mapper = new ModelMapper();

    return countryLanguagesRepository.findAllByCountryCode(countryCode)
        .stream()
        .map(entity -> mapper.map(entity, CountryLanguageDto.class))
        .map(countryLanguageDto -> {
          countryLanguageDto.setPort(port);
          countryLanguageDto.setAppName(appName);
          return countryLanguageDto;
        })
        .toList();
  }

  public List<CountryLanguageDto> findAllByLanguage(String countryCode) {
    ModelMapper mapper = new ModelMapper();

    return countryLanguagesRepository.findAllByLanguage(countryCode)
        .stream()
        .map(entity -> mapper.map(entity, CountryLanguageDto.class))
        .map(countryLanguageDto -> {
          countryLanguageDto.setPort(port);
          countryLanguageDto.setAppName(appName);
          return countryLanguageDto;
        })
        .toList();
  }
}
