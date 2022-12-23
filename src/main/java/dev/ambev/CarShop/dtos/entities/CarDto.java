package dev.ambev.CarShop.dtos.entities;

import dev.ambev.CarShop.entities.Car;
import lombok.Data;

@Data
public class CarDto {
    private String brand;
    private String model;
    private Boolean available;

    CarDto(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.available = car.getAvailable();
    }
}
