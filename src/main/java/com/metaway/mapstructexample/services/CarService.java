package com.metaway.mapstructexample.services;

import com.metaway.mapstructexample.dto.CarDTO;
import com.metaway.mapstructexample.entities.Car;
import com.metaway.mapstructexample.mappers.CarMapper;
import com.metaway.mapstructexample.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private CarMapper carMapper;

    @Transactional(readOnly = true)
    public List<CarDTO> findAll(){
        List<Car> list = repository.findAll();
        return carMapper.entityListToDTOList(list);
    }

    @Transactional(readOnly = true)
    public CarDTO findById(Long id){
        Car entity = repository.findById(id).get();
        return carMapper.entityToDto(entity);
    }
}
