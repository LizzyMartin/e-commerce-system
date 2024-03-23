package com.fiap.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.auth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(Authentication authentication, @RequestParam String id) {
        try {
            var user = userService.findByID(id);
            return ResponseEntity.ok(user.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not found");
        }        
    }

    @PostMapping("/admin")
    public ResponseEntity<String> createAdmin(Authentication authentication, @RequestParam String username, @RequestParam String password) {
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return ResponseEntity.badRequest().body("You don't have permission to create an admin");
        }
        userService.createNewAdmin(username, password);
        return ResponseEntity.ok("Admin created");
    }

    @PostMapping
    public ResponseEntity<String> createUser(Authentication authentication, @RequestParam String username, @RequestParam String password) {
        userService.createNewUser(username, password);
        return ResponseEntity.ok("User created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(Authentication authentication, @RequestParam String id) {
        var user = userService.findByID(id);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (user.getRole().equals("admin") && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return ResponseEntity.badRequest().body("You don't have permission to delete an admin");
        }

        userService.deleteByID(id);
        return ResponseEntity.ok("User deleted");
    }

    @PutMapping
    public ResponseEntity<String> updatePassword(Authentication authentication, @RequestParam String id, @RequestParam String password) {
        var user = userService.findByID(id);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (user.getRole().equals("admin") && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return ResponseEntity.badRequest().body("You don't have permission to update an admin's password");
        }

        userService.updatePassword(id, password);
        return ResponseEntity.ok("Password updated");
    }
    
}
