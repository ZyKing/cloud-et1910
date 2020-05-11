package com.etoak;

import com.alibaba.fastjson.JSONObject;
import com.etoak.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class TestUserController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/testGet")
    public User testGet(@RequestParam(required = false,defaultValue = "123") int id){
        String url = "http://user-service/user-sys/user/queryById?id="+id;
        return restTemplate.getForObject(url,User.class);
    }
    @RequestMapping("/testPostForm")
    public User testPostForm(){
        String url = "http://user-service/user-sys/user/add";
        MultiValueMap<String,String> requestBody = new LinkedMultiValueMap<>();
        requestBody.set("id","111");
        requestBody.set("name","et1910");
        requestBody.set("age","20");
        requestBody.set("birthday","2020-01-01");
        return restTemplate.postForObject(url,requestBody,User.class);
    }
    @RequestMapping("/testJson")
    public String testJson(User user){
        String url = "http://user-service/user-sys/user/update";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.ALL));
        HttpEntity<String> param = new HttpEntity<>(JSONObject.toJSONString(user),httpHeaders);
        restTemplate.put(url,param);
        return "SUCCESS";
    }
}
