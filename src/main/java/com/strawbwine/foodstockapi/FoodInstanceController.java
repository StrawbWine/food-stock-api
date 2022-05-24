package com.strawbwine.foodstockapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodInstanceController {
    private final FoodInstanceRepository repository;

    FoodInstanceController(FoodInstanceRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/foodinstances")
    List<FoodInstance> all(@RequestParam(value = "food_type_name", defaultValue = "") String foodTypeName) {
        if(foodTypeName.equals("")) {
            return repository.findAll();
        } else return repository.findByFoodTypeName(foodTypeName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/foodinstances")
    FoodInstance newFoodInstance(@RequestBody FoodInstance newFoodInstance) {
        return repository.save(newFoodInstance);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/foodinstances/{id}")
    void deleteFoodInstance(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
