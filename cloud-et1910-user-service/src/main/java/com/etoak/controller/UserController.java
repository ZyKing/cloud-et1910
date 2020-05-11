package com.etoak.controller;

import com.etoak.bean.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/queryById")
    public User queryById(@RequestParam int id){
        System.out.println("param id - "+id);
        User user = new User();
        user.setId(id);
        user.setName("et1910");
        user.setAge(18);
        user.setBirthday("2002-01-01");
        return user;
    }
    @PostMapping("/add")
    public User addUser(User user){
        System.out.println(user);
        return user;
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        System.out.println("UserService updateUser");
        return user;
    }
}
