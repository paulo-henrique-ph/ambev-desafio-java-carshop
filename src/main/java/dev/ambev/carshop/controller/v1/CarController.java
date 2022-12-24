package dev.ambev.carshop.controller.v1;

import dev.ambev.carshop.dto.entitiy.CarDto;
import dev.ambev.carshop.entity.Car;
import dev.ambev.carshop.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CarController {
    public  static final String BASE_URL = "/car";
    public static final String GET_BY_ID_URL = BASE_URL + "/{id}";

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    private final CarService carService;

    @GetMapping(BASE_URL)
    public List<Car> findAvailableCarByBrandOrModel(@RequestParam Optional<String> brand, Optional<String> model) {
        return  carService.findAvailableCarByBrandOrModel(brand.orElse(""), model.orElse(""));
    }
    @GetMapping(GET_BY_ID_URL)
    public Car findCarById(@PathVariable UUID id) {
        return carService.findCarById(id);
    }

    @PostMapping(BASE_URL)
    public Car createCar(@RequestBody @Valid CarDto carDto) {
        return carService.createCar(carDto);
    }

    @PutMapping(GET_BY_ID_URL)
    public  Car updateCar(@PathVariable UUID id, @RequestBody CarDto carDto) { return carService.updateCar(id, carDto); }

    @DeleteMapping(GET_BY_ID_URL)
    public  void deleteCar(@PathVariable UUID id) { carService.deleteCarById(id); }
}
