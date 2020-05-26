package com.shaw.springbootlogin.service.impl;

import com.shaw.springbootlogin.model.MovieInfo;
import com.shaw.springbootlogin.mapper.MovieInfoMapper;
import com.shaw.springbootlogin.service.MovieInfoService;
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
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper, MovieInfo> implements MovieInfoService {

}
