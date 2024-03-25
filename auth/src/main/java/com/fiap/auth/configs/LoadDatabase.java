package com.fiap.auth.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fiap.auth.model.User;
import com.fiap.auth.repository.UserRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            repository.save(new User("user", passwordEncoder.encode("password"), "user"));
            repository.save(new User("admin", passwordEncoder.encode("password"), "admin"));
        };
    }
    
}
