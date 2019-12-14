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
        //  不同的创建错误应该返回不同的信息。这里还没有进行区分。

        //  确认密码错误。这个逻辑应该放在界面js上写，即时反馈。
        if(!form.getPassword().equals(form.getPasswordRepeat())){
            return null;
        }
        if(this.getUserByUserName(form.getUserName())!=null){
            return null;
        }
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        System.out.println(user.toString());

        return userRepository.save(user);
    }
}
