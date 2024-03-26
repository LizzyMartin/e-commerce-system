package com.fiap.items.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.items.models.Item;
import com.fiap.items.repositories.ItemRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.insert(new Item("Escova secadora", "110V", 79.99, 1));
            repository.insert(new Item("Notebook Windows", "i5 256gb ssd", 2899.99, 1));
            repository.insert(new Item("Bala Fini", "Sabor cítrico", 10.50, 4));
            repository.insert(new Item("Travesseiro", "Penas de ganso", 49.99, 1));
        };
    }
    
}
