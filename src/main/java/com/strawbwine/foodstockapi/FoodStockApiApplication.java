package com.strawbwine.foodstockapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodStockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodStockApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FoodTypeRepository foodTypeRepository) {
		return args -> {
			FoodType pizza = new FoodType("Pizza");
			foodTypeRepository.save(pizza);
		};
	}

}
