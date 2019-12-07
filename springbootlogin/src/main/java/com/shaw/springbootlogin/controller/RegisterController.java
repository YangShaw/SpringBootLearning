package com.shaw.springbootlogin.controller;

import com.shaw.springbootlogin.model.User;
import com.shaw.springbootlogin.model.UserCreateForm;
import com.shaw.springbootlogin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("user_register")
    public String createUser(Model model,
                             @RequestParam("username")String userName,
                             @RequestParam("password")String password){

        UserCreateForm userCreateForm = new UserCreateForm();
        userCreateForm.setUserName(userName);
        userCreateForm.setPassword(password);
        User user = userService.createNewUser(userCreateForm);
        if(user!=null){
            model.addAttribute("reg_msg", "register success");
        } else {
            model.addAttribute("reg_msg", "register failed");
        }
        return "login";
    }

}
