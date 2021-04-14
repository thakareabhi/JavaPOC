package com.example.bct.Ecommerce.services;

import com.example.bct.Ecommerce.entity.User;
import com.example.bct.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        user.setCreatedOn(new Date());
        user.setUpdatedOn(new Date());
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getUserActive())
        {

        }
        else {
            user.setUserActive(false);
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        List<User> userList = userRepository.findAll();
        User user=null;
        user = userList.stream().filter(e->e.getUserId()==id).findFirst().get();
        return user;
    }
    public List<User> getAllUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public String deleteUserById(Long id){
        List<User> userList = userRepository.findAll();
        User user=null;
        user = userList.stream().filter(e->e.getUserId()==id).findFirst().get();
        userRepository.delete(user);
        return "DELETED "+user.getFirstName()+" "+user.getLastName();
    }

    public Long getUserId(Principal principal) {
        String email=principal.getName();
        return userRepository.getUsersByEmail(email).getUserId();
    }
}
