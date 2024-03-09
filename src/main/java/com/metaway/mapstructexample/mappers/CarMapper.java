package com.metaway.mapstructexample.mappers;

import com.metaway.mapstructexample.dto.CarDTO;
import com.metaway.mapstructexample.entities.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = CarMapper.class)
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "brand.name", target = "brandName") // se algum atributo tiver nome diferente do outro
    @Mapping(source = "driver.id", target = "driverId")
    CarDTO entityToDto(Car car);

    @InheritInverseConfiguration
    Car dtoToEntity(CarDTO carDTO);

    List<CarDTO> entityListToDTOList(List<Car> entityList);
    List<Car> dtoListToEntityList(List<CarDTO> entityList);
}