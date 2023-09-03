package com.schoolofnet.template.repository;

import com.schoolofnet.template.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
