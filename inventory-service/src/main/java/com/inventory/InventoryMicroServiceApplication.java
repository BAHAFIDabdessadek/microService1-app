package com.inventory;

import com.inventory.repository.InventoryRepository;
import com.inventory.service.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return args -> {

			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone-13");
			inventory.setQuantity(12);
			inventoryRepository.save(inventory);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Iphone-14");
			inventory2.setQuantity(0);

			inventoryRepository.save(inventory2);
		};
	}
}
