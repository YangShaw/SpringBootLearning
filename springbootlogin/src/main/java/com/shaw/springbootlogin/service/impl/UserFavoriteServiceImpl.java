package com.shaw.springbootlogin.service.impl;

import com.shaw.springbootlogin.model.UserFavorite;
import com.shaw.springbootlogin.mapper.UserFavoriteMapper;
import com.shaw.springbootlogin.service.UserFavoriteService;
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
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite> implements UserFavoriteService {

}
