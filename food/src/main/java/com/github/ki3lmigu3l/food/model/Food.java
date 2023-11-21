package com.github.ki3lmigu3l.food.model;

import com.github.ki3lmigu3l.food.dto.FoodRecordRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String imagem;
    private BigDecimal preco;

    public Food(FoodRecordRequest foodRequest) {
        this.nome = foodRequest.nome();
        this.imagem = foodRequest.imagem();
        this.preco = foodRequest.preco();
    }
}
