package com.gill.spring5recipeapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {

    @Id
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;
}
