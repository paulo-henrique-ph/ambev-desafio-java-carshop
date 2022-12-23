package dev.ambev.carshop.controller.v1;

import dev.ambev.carshop.dto.entitiy.CarDto;
import dev.ambev.carshop.entity.Car;
import dev.ambev.carshop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CarController {
    public  static final String BASE_URL = "/car";
    public static final String GET_BY_ID_URL = BASE_URL + "/{id}";

    private final CarService carService;

    @GetMapping(GET_BY_ID_URL)
    public Car findCarById(@PathVariable UUID id) {
        return carService.findCarById(id);
    }

    @PostMapping(BASE_URL)
    public Car createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }
}
