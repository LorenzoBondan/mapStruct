package com.metaway.mapstructexample.controllers;

import com.metaway.mapstructexample.dto.CarDTO;
import com.metaway.mapstructexample.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll(){
        List<CarDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long id){
        CarDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
