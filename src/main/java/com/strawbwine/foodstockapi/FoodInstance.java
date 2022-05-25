package com.strawbwine.foodstockapi;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "food_instance")
public class FoodInstance {

    @Id
    @SequenceGenerator(
            name = "foodinstance_sequence",
            sequenceName = "foodinstance_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "foodinstance_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="food_type_id",
            nullable = false
    )
    private FoodType foodType;
    @Column(
            name="purchase_date"
    )
    private LocalDate purchaseDate;
    @Column(
            name="expiration_date"
    )
    private LocalDate expirationDate;
    @Column(
            name="created_time"
    )
    private final Instant createdTime = Instant.now();

    public FoodInstance() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }
}
