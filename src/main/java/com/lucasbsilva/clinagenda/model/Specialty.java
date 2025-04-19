package com.lucasbsilva.clinagenda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer scheduleDuration;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getScheduleDuration() { return scheduleDuration; }
    public void setScheduleDuration(Integer scheduleDuration) { this.scheduleDuration = scheduleDuration; }
}
