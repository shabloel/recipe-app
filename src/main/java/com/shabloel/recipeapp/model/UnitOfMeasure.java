package com.shabloel.recipeapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author christiaan.griffioen on feb, 2021
 */
@Data
@Entity
@Table(name = "Unit_Of_Measure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Ingredient ingredient;
}
