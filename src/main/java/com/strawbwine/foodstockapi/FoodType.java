package com.strawbwine.foodstockapi;

import javax.persistence.*;
import java.time.Instant;

@Entity
class FoodType {
    @Id
    @SequenceGenerator(
            name = "foodtype_sequence",
            sequenceName = "foodtype_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "foodtype_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private long id;
    @Column(
            name="name",
            nullable = false
    )
    private String name;
    @Column(
            name="kcal_per_hundred_grams"
    )
    private int kcalPerHundredGrams;
    @Column(
            name="weight_in_grams"
    )
    private int weightInGrams;
    @Column(
            name="description"
    )
    private String description;
    @Column(
            name="created_time"
    )
    private Instant createdTime;

    public FoodType() {
    }

    public FoodType(String name, int kcalPerHundredGrams, int weightInGrams, String description) {
        this.name = name;
        this.kcalPerHundredGrams = kcalPerHundredGrams;
        this.weightInGrams = weightInGrams;
        this.description = description;
        this.createdTime = Instant.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcalPerHundredGrams() {
        return kcalPerHundredGrams;
    }

    public void setKcalPerHundredGrams(int kcalPerHundredGrams) {
        this.kcalPerHundredGrams = kcalPerHundredGrams;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }
}
