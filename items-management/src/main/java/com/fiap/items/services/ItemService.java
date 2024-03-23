package com.fiap.items.services;

import org.springframework.stereotype.Service;

import com.fiap.items.models.Item;
import com.fiap.items.repositories.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }

    public void update(Item item) {
        itemRepository.save(item);
    }

}
