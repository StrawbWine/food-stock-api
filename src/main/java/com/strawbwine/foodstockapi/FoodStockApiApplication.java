package com.strawbwine.foodstockapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class FoodStockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodStockApiApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(FoodTypeRepository foodTypeRepository) {
//		return args -> {
//			FoodType pizza = new FoodType("Pizza", 250, 550, "A delicious pizza");
//			foodTypeRepository.save(pizza);
//		};
//	}

}
