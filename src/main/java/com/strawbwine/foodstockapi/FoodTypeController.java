package com.strawbwine.foodstockapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodTypeController {
    private final FoodTypeRepository repository;

    FoodTypeController(FoodTypeRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/foodtypes")
    List<FoodType> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/foodtypes")
    FoodType newFoodType(@RequestBody FoodType newFoodType) {
        return repository.save(newFoodType);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/foodtypes/{id}")
    void deleteFoodType(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
