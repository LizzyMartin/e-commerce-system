package com.fiap.items.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fiap.items.models.Item;
import com.fiap.items.services.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable String id) {
        return itemService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(Authentication authentication, @RequestBody Item item) {
        if (authentication.getName().equals("admin")) {
            return ResponseEntity.status(403).body("Forbidden");
        }
        itemService.save(item);
        return ResponseEntity.ok("Item saved");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(Authentication authentication, @PathVariable String id) {
        if (authentication.getName().equals("admin")) {
            return ResponseEntity.status(403).body("Forbidden");
        }
        itemService.deleteById(id);
        return ResponseEntity.ok("Item deleted");
    }

    @PutMapping
    public ResponseEntity<String> update(Authentication authentication, @RequestBody Item item) {
        if (authentication.getName().equals("admin")) {
            return ResponseEntity.status(403).body("Forbidden");
        }
        itemService.update(item);
        return ResponseEntity.ok("Item updated");
    }

}
