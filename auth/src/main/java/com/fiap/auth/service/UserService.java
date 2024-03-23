package com.fiap.auth.service;

import org.springframework.stereotype.Service;

import com.fiap.auth.model.User;
import com.fiap.auth.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByID(String id) {
        return userRepository.findById(id).get();
    }

    public void createNewAdmin(String username, String password) {
        userRepository.save(new User(username, password, "admin"));
    }

    public void createNewUser(String username, String password) {
        userRepository.save(new User(username, password, "user"));
    }

    public void deleteByID(String id) {
        userRepository.deleteById(id);
    }

    public void updatePassword(String id, String password) {
        User user = userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);
    }

}
