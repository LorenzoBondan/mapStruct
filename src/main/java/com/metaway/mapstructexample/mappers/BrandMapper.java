package com.metaway.mapstructexample.mappers;

import com.metaway.mapstructexample.dto.BrandDTO;
import com.metaway.mapstructexample.dto.CarDTO;
import com.metaway.mapstructexample.entities.Brand;
import com.metaway.mapstructexample.entities.Car;
import com.metaway.mapstructexample.entities.Driver;
import com.metaway.mapstructexample.repositories.CarRepository;
import com.metaway.mapstructexample.services.CarService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CarService.class, CarMapper.class})
public interface BrandMapper {

    @Mapping(source = "brand.cars", target = "carsIds", qualifiedByName = "ListOfEntityToLong")
    BrandDTO entityToDTO(Brand brand);

    @Named("ListOfEntityToLong")
    default List<Long> mapCarsToIds(List<Car> cars) {
        return cars.stream()
                .map(Car::getId)
                .collect(Collectors.toList());
    }
    /*
    @Mapping(source = "brandDTO.carsIds", target = "cars", qualifiedByName = "ListOfLongToEntity")
    Brand dtoToEntity(BrandDTO brandDTO);

    @Named("ListOfLongToEntity")
    default List<Car> mapCarsIdsToCars(List<Long> carsIds) {
        CarService carService = new CarService();
        List<Car> cars = new ArrayList<>();
        List<CarDTO> carsDTO = new ArrayList<>();
        for(Long carId : carsIds){
            CarDTO carDTO = carService.findById(carId);
            Car car = new Car();
            car.setId(carDTO.getId());
            car.setName(carDTO.getName());
            car.setCarYear(carDTO.getCarYear());
            car.setBrand(carDTO.ge);
        }

        return carsIds.stream()
                .map(carId -> carService.findById(carId))
                .collect(Collectors.toList());
    }
    */
    List<BrandDTO> entityListToDTOList(List<Brand> entityList);
    List<Brand> dtoListToEntityList(List<BrandDTO> entityList);
}
