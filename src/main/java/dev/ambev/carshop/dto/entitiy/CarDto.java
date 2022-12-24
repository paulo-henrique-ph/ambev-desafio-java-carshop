package dev.ambev.carshop.dto.entitiy;

import dev.ambev.carshop.entity.Car;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@Data
public class CarDto {
    @NotBlank(message="{brand.required}")
    private String brand;
    @NotBlank(message="{model.required}")
    private String model;

    private Boolean available;

    CarDto(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.available = car.getAvailable();
    }
}
