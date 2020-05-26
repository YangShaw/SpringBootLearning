package com.shaw.springbootlogin.service.impl;

import com.shaw.springbootlogin.model.UserRating;
import com.shaw.springbootlogin.mapper.UserRatingMapper;
import com.shaw.springbootlogin.service.UserRatingService;
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
public class UserRatingServiceImpl extends ServiceImpl<UserRatingMapper, UserRating> implements UserRatingService {

}
