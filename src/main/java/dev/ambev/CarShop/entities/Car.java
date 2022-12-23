package dev.ambev.CarShop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(
        name = "car",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"brand", "model"})
        }
)
public class Car {
    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String brand;
    private String model;
    private Boolean available;
}
