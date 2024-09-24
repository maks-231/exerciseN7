package com.microservices.countries.repository;

import com.microservices.countries.entity.CityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<CityEntity, Long>, JpaSpecificationExecutor<CityEntity> {
  CityEntity findByName(String name);
}
