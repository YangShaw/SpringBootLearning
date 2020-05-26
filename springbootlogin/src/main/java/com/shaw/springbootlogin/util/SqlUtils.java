package com.shaw.springbootlogin.util;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shaw.springbootlogin.model.MovieInfo;
import com.shaw.springbootlogin.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlUtils {

    @Autowired
    static MovieInfoService movieInfoService;
    public static MovieInfo getMovieInfoById(String itemId){
        QueryWrapper<MovieInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_id", itemId);
        MovieInfo movieInfo = movieInfoService.getOne(queryWrapper);
        return movieInfo;
    }
}
