package com.shaw.springbootlogin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shaw.springbootlogin.model.UserInfo;
import com.shaw.springbootlogin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaw
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/api/user-info")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("list")
    public List<UserInfo> selectListByPage(){
        Integer limit = 50;
        Integer page = 1;
        Page<UserInfo> userInfoPage = new Page<>(page, limit);
        userInfoService.page(userInfoPage, null);
        List<UserInfo> result = userInfoPage.getRecords();
        return result;
    }

}

