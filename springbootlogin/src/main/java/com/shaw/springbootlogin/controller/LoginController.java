package com.shaw.springbootlogin.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.shaw.springbootlogin.model.Info;
import com.shaw.springbootlogin.model.User;
import com.shaw.springbootlogin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/")
    public String first(){
        return "login";
    }

    @RequestMapping("login")
    public ModelAndView hello(){
        List<Info> infoList = new ArrayList<>();
        Info bean = new Info("title1", "content1");
        infoList.add(bean);
        bean = new Info("title2", "content2");
        infoList.add(bean);

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("infoList", infoList);
        return modelAndView;
    }

    @RequestMapping("user_login")
    public String userLogin(Model model,
                            @RequestParam("username")String userName,
                            @RequestParam("password")String password){
        System.out.println(userName);
        System.out.println(password);

        User user = userService.getUserByUserName(userName);

        if(user!=null && user.getPassword().equals(password)){
            System.out.println("登录成功");
            return "home";
        } else {
            System.out.println("登录失败");
            return "error";
        }
    }
}
