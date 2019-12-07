package com.shaw.springbootlogin.service;

import com.shaw.springbootlogin.model.User;
import com.shaw.springbootlogin.model.UserCreateForm;
import com.shaw.springbootlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User createNewUser(UserCreateForm form) {
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());

        System.out.println(user.toString());

        return userRepository.save(user);
    }
}
