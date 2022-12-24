package dev.ambev.carshop.service;

import dev.ambev.carshop.converter.CarConverter;
import dev.ambev.carshop.dto.entitiy.CarDto;
import dev.ambev.carshop.entity.Car;
import dev.ambev.carshop.exception.DomainItemNotFoundException;
import dev.ambev.carshop.repository.CarRepository;
import dev.ambev.carshop.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<Car> findAvailableCarByBrandOrModel(String brand, String model) {
        return carRepository.findAvailableCarByBrandOrModel(brand, model);
    }

    public Car findCarById(UUID id) {
        return carRepository.findById(id).orElseThrow(() -> new DomainItemNotFoundException(ErrorMessage.CAR_NOT_FOUND, id.toString()));
    }

    public Car createCar(CarDto carDto) {
        final Car car = CarConverter.toEntity(carDto);

        return carRepository.save(car);
    }

    public Car updateCar(UUID id, CarDto carDto) {
        Car car = carRepository.findById(id).orElseThrow(() -> new DomainItemNotFoundException(ErrorMessage.CAR_NOT_FOUND, id.toString()));

        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setAvailable(carDto.getAvailable());

        return carRepository.save(car);
    }

    public void deleteCarById(UUID id) {
        carRepository.deleteById(id);
    }


}
