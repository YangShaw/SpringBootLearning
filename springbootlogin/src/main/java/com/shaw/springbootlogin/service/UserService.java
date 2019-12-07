package com.shaw.springbootlogin.service;

import com.shaw.springbootlogin.model.User;
import com.shaw.springbootlogin.model.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    User getUserByUserName(String userName);
    User createNewUser(UserCreateForm form);
}
