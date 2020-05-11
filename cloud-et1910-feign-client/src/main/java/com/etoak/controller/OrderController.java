package com.etoak.controller;

import com.etoak.bean.User;
import com.etoak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    UserService userService;
    @RequestMapping("/{id}")
    public Object queryById(@PathVariable("id") String id){
        Map<String,Object> result = new HashMap<>();
        result.put("id",id);
        User user = userService.queryById(123);
        result.put("user",user);
        return result;
    }
    @RequestMapping("/testUserAdd")
    public User addUser(User user){
        User result = userService.addUser(user.getId(),
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getBirthday());
        return result;
    }
    @RequestMapping("/testUpdateUser")
    public User updateUser(User user){
        System.out.println("OrderService updateUser");
        User result = userService.updateUser(user);
        return result;
    }
}
