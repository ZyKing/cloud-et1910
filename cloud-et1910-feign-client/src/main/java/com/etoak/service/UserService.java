package com.etoak.service;


import com.etoak.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user-service")
@RequestMapping("/user-sys/user")
public interface UserService {
    @GetMapping("/queryById")
    public User queryById(@RequestParam(value = "id") int id);
    @PostMapping("/add")
    public User addUser(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("age") int age,
                        @RequestParam("gender") String gender,@RequestParam("birthday") String birthday);
    @PutMapping("/update")
    public User updateUser(@RequestBody User user);
}
