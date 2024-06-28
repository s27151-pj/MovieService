package com.example.movieservice;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String category;

    @Column(name = "number_of_minute")
    private int numberOfMinutes;

    @Column(nullable = false)
    private boolean isAvailable = false;

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Default constructor
    public Movie() {
    }
    public Movie(String name, String category, int numberOfMinutes) {
        this.name = name;
        this.category = category;
        this.numberOfMinutes = numberOfMinutes;
    }
    // Parameterized constructor
    public Movie(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}