package dev.ambev.carshop.repository;

import dev.ambev.carshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    @Query("SELECT c " +
            "FROM Car c " +
            "WHERE (:brand = '' OR UPPER(c.brand) = UPPER(:brand)) " +
            "AND (:model = '' OR UPPER(c.model) = UPPER(:model)) " +
            "AND c.available = true")
    List<Car> findAvailableCarByBrandOrModel(@Param("brand") String brand, @Param("model") String model);

}
