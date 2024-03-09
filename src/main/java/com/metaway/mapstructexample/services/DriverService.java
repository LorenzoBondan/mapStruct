package com.metaway.mapstructexample.services;

import com.metaway.mapstructexample.dto.DriverDTO;
import com.metaway.mapstructexample.entities.Driver;
import com.metaway.mapstructexample.mappers.DriverMapper;
import com.metaway.mapstructexample.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    @Autowired
    private DriverMapper driverMapper;

    @Transactional(readOnly = true)
    public List<DriverDTO> findAll(){
        List<Driver> list = repository.findAll();
        return driverMapper.entityListToDTOList(list);
    }

    @Transactional(readOnly = true)
    public DriverDTO findById(Long id){
        Driver entity = repository.findById(id).get();
        return driverMapper.driverToDriverDTO(entity);
    }
}
