package com.shaw.springbootlogin.controller;

import com.shaw.springbootlogin.model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //  表示发送一个/hello请求的时候做出的响应



    @RequestMapping("index")
    public String entrance(){
        return "index";
    }

}
