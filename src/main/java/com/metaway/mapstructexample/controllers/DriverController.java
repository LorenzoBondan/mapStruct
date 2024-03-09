package com.metaway.mapstructexample.controllers;

import com.metaway.mapstructexample.dto.DriverDTO;
import com.metaway.mapstructexample.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<List<DriverDTO>> findAll(){
        List<DriverDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> findById(@PathVariable Long id){
        DriverDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
