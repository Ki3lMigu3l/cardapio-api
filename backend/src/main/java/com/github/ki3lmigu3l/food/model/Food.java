package com.github.ki3lmigu3l.food.model;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String description;
    private BigDecimal price;

    public Food(FoodRequest foodRequest) {
        this.name = foodRequest.name();
        this.image = foodRequest.image();
        this.description = foodRequest.description();
        this.price = foodRequest.price();
    }

    public Food(long id, String name, String image, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }
}
