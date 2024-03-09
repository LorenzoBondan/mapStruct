package com.metaway.mapstructexample.mappers;

import com.metaway.mapstructexample.dto.CarDTO;
import com.metaway.mapstructexample.dto.DriverDTO;
import com.metaway.mapstructexample.entities.Car;
import com.metaway.mapstructexample.entities.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = DriverMapper.class)
public interface DriverMapper {

    @Mapping(source = "cars", target = "carsDTO")
    DriverDTO driverToDriverDTO(Driver driver);

    default List<CarDTO> mapCarsToCarsDTO(List<Car> cars) {
        return cars.stream()
                .map(CarMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
    }

    List<DriverDTO> entityListToDTOList(List<Driver> entityList);
    List<Driver> dtoListToEntityList(List<DriverDTO> entityList);
}
