package com.microservices.countries.repository;

import com.microservices.countries.entity.CountryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>, JpaSpecificationExecutor<CountryEntity> {
  CountryEntity findByName(String name);
}
