package com.shaw.springbootlogin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shaw.springbootlogin.model.MovieInfo;
import com.shaw.springbootlogin.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/movie-info")
public class MovieInfoController {

    @Autowired
    MovieInfoService movieInfoService;

    @PostMapping(value = "list", produces = "application/json;charset=UTF-8")
    public List<MovieInfo> selectListByPage(@RequestParam(value="page") Integer page){
        QueryWrapper<MovieInfo> queryWrapper = new QueryWrapper<>();
        Integer limit = 50;
        Page<MovieInfo> movieInfoPage = new Page<>(page, limit);
        movieInfoService.page(movieInfoPage, null);
        List<MovieInfo> result = movieInfoPage.getRecords();
        return result;
    }

    @GetMapping("list")
    public List<MovieInfo> selectListByPage(){
        QueryWrapper<MovieInfo> queryWrapper = new QueryWrapper<>();
        Integer limit = 50;
        Page<MovieInfo> movieInfoPage = new Page<>(1, limit);
        movieInfoService.page(movieInfoPage, null);
        List<MovieInfo> result = movieInfoPage.getRecords();
        return result;
    }

}

