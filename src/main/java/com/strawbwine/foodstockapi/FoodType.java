package com.strawbwine.foodstockapi;

import javax.persistence.*;

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
    private long id;
    private String name;

    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
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
}
