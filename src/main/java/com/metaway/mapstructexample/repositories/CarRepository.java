package com.metaway.mapstructexample.repositories;

import com.metaway.mapstructexample.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
