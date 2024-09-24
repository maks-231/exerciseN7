package com.microservices.country.languages.repository;

import com.microservices.country.languages.entity.CountryLanguageEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface CountryLanguagesRepository extends JpaRepository<CountryLanguageEntity, Long>, JpaSpecificationExecutor<CountryLanguageEntity> {
  List<CountryLanguageEntity> findAllByCountryCode(String countryCode);
  List<CountryLanguageEntity> findAllByLanguage(String language);
}
