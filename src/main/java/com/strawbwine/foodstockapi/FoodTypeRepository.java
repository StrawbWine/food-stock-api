package com.strawbwine.foodstockapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
    List<FoodType> findByName(String name);
}
