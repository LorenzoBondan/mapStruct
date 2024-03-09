package com.metaway.mapstructexample.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private Long id;
    private String name;
    private List<Long> carsIds = new ArrayList<>();

    public BrandDTO(){}

    public BrandDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCarsIds() {
        return carsIds;
    }
}
