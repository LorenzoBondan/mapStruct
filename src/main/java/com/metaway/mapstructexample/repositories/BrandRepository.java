package com.metaway.mapstructexample.repositories;

import com.metaway.mapstructexample.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
