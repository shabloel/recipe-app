package com.shabloel.recipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author christiaan.griffioen on feb, 2021
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notes_id")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Recipe recipe;

    @Lob // standard db only allows 255 characters, this anno expands this by using clob field in the db
    @Column(name = "recipe_notes")
    private String recipeNotes;

}
