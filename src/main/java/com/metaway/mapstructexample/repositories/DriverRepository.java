package com.metaway.mapstructexample.repositories;

import com.metaway.mapstructexample.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
