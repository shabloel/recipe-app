package com.shabloel.recipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author christiaan.griffioen on feb, 2021
 */
@Data
@EqualsAndHashCode(exclude = {"recipe", "unitOfMeasure", })
@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uom_id", referencedColumnName = "uom_id")
    private UnitOfMeasure unitOfMeasure;

}
