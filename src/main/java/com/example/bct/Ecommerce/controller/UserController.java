package com.example.bct.Ecommerce.controller;

import com.example.bct.Ecommerce.constants.ApiName;
import com.example.bct.Ecommerce.entity.User;
import com.example.bct.Ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.example.bct.Ecommerce.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = ApiName.USER_ADD)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(value = ApiName.USER_GET)
    public User getUserById(@PathVariable("id") Long id) {
       return userService.getUserById(id);
    }

    @GetMapping(value = ApiName.USER_GETAll)
    public List<User> getAllUsers(Principal principal) {
        System.out.println(principal.getName());
        return userService.getAllUser();
    }

    @DeleteMapping(value = ApiName.USER_DELETE)
    public String deleteUserById(@PathVariable("id") Long id) {

        return userService.deleteUserById(id);
    }


}
