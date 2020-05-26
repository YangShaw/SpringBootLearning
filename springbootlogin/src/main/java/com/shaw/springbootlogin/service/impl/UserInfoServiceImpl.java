package com.shaw.springbootlogin.service.impl;

import com.shaw.springbootlogin.model.UserInfo;
import com.shaw.springbootlogin.mapper.UserInfoMapper;
import com.shaw.springbootlogin.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaw
 * @since 2020-05-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
