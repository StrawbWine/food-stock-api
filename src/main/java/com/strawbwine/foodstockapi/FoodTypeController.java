package com.strawbwine.foodstockapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodTypeController {
    private final FoodTypeRepository repository;

    FoodTypeController(FoodTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/foodtypes")
    List<FoodType> all() {
        return repository.findAll();
    }

    @PostMapping("/foodtypes")
    FoodType newFoodType(@RequestBody FoodType newFoodType) {
        return repository.save(newFoodType);
    }
}
