package dev.ambev.CarShop.repositories;

import dev.ambev.CarShop.dtos.entities.CarDto;
import dev.ambev.CarShop.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query("SELECT new dev.ambev.CarShop.dtos.entities.CarDto(c) " +
            "FROM Car c" +
            "WHERE (:brand IS NULL OR UPPER(c.brand) = UPPER(:brand) " +
            "AND (:model IS NULL OR UPPER(c.model) = UPPER(:model) " +
            "AND c.available = true"
    )
    List<CarDto> findAvailableByBrandOrModel(@Param("brand") String brand,
                                             @Param("model") String model);
}
