package com.company.sign.controller;
import com.company.sign.model.User;
import com.company.sign.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SignController {

    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{mobile}")
    public Optional<User> getUserInfo(@PathVariable String rno) {
        return userService.getUserInfo(rno);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{mobile}")
    public User editUser(@PathVariable String mobile, @RequestBody User user) {
        return userService.editUser(mobile, user);
        // return user;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{mobile}")
    public Optional<User> deleteUser(@PathVariable String mobile) {
        return userService.deleteUser(mobile);
    }
}

