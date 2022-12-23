package dev.ambev.carshop.converter;

import dev.ambev.carshop.entity.Car;
import dev.ambev.carshop.dto.entitiy.CarDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarConverter {
    public static Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setAvailable(carDto.getAvailable());
        return car;
    }
}
