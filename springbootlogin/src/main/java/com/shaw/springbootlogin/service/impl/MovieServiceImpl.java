package com.shaw.springbootlogin.service.impl;

import com.shaw.springbootlogin.model.Movie;
import com.shaw.springbootlogin.mapper.MovieMapper;
import com.shaw.springbootlogin.service.MovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaw
 * @since 2020-05-25
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

}
