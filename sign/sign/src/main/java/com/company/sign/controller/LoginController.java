package com.company.sign.controller;

import com.company.sign.model.User;
import com.company.sign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Optional<User> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userRepository.findById( user.getMobile() );
        if(loggedInUser.isPresent()) {
            if(loggedInUser.get().getPassword().equals(user.getPassword())) {
                return loggedInUser;
            }
        }
        return Optional.empty();
    }
}
