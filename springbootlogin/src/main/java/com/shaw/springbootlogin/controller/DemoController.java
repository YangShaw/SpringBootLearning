package com.shaw.springbootlogin.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaw.springbootlogin.model.User;
import com.shaw.springbootlogin.model.UserCreateForm;
import com.shaw.springbootlogin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entry")
public class DemoController {

    @Autowired
    UserServiceImpl userService;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value="/demo", method = RequestMethod.GET)
    public String demoQry() {
        return "API DEMO";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody String json) throws Exception {
        JsonNode jsonNode = mapper.readTree(json);
        String name = jsonNode.path("username").textValue();
        String pwd = jsonNode.path("password").textValue();
        System.out.println(name);
        System.out.println(pwd);

        User user = userService.getUserByUserName(name);

        if(user!=null && user.getPassword().equals(pwd)){
            System.out.println("登录成功");
            return "/homepage";
        } else {
            System.out.println("登录失败");
            return "/error";
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(@RequestBody String json) throws Exception {
        JsonNode jsonNode = mapper.readTree(json);
        String name = jsonNode.path("username").textValue();
        String pwd = jsonNode.path("password").textValue();
        System.out.println(name);
        System.out.println(pwd);

        UserCreateForm userCreateForm = new UserCreateForm();

        userCreateForm.setUserName(name);
        userCreateForm.setPassword(pwd);
        userCreateForm.setPasswordRepeat(pwd);
        User user = userService.createNewUser(userCreateForm);
        if(user!=null){
            System.out.println("注册成功");
            return "/";
        } else {
            System.out.println("注册失败");
            return "/error";
        }
    }
}
