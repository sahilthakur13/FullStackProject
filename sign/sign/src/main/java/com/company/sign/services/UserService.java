package com.company.sign.services;

import com.company.sign.model.User;
import com.company.sign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public Optional<User> getUserInfo(String mobile) {
        return userRepository.findById(mobile);
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public User editUser(String mobile, User updatedUser) {
        userRepository.save(updatedUser);
        return updatedUser;
    }
    public Optional<User> deleteUser(String mobile) {
        Optional<User> user = userRepository.findById(mobile);
        userRepository.deleteById(mobile);
        return user;
    }
}

