package com.strawbwine.foodstockapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FoodInstanceController {
    private final FoodInstanceRepository repository;
    private final FoodTypeRepository foodTypeRepository;

    FoodInstanceController(FoodInstanceRepository repository, FoodTypeRepository foodTypeRepository) {
        this.repository = repository;
        this.foodTypeRepository = foodTypeRepository;
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
    FoodInstance newFoodInstance(@RequestBody String newFoodInstanceString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonObject = mapper.readTree(newFoodInstanceString);
        String foodTypeString = jsonObject.get("foodType").asText();
        System.out.println(foodTypeString);
        List<FoodType> referencedFoodType = foodTypeRepository.findByName(foodTypeString);
        FoodInstance newFoodInstance = new FoodInstance();
        newFoodInstance.setFoodType(referencedFoodType.get(0));
        newFoodInstance.setPurchaseDate(LocalDate.parse(jsonObject.get("purchaseDate").asText()));
        newFoodInstance.setExpirationDate(LocalDate.parse(jsonObject.get("expirationDate").asText()));
        return repository.save(newFoodInstance);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/foodinstances/{id}")
    void deleteFoodInstance(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
