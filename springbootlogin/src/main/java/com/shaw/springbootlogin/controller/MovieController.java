package com.shaw.springbootlogin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shaw.springbootlogin.model.Movie;
import com.shaw.springbootlogin.model.UserFavorite;
import com.shaw.springbootlogin.service.MovieService;
import com.shaw.springbootlogin.service.UserFavoriteService;
import javafx.scene.shape.MoveTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserFavoriteService userFavoriteService;

    @GetMapping("list")
    public List<Movie> list(){
        List<Movie> list = movieService.list(null);
        return list;
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public String addMovie(@RequestBody Movie movie){
        movieService.save(movie);
        System.out.println(movie);
        return movie.toString();
    }

    @GetMapping(value="/favorite/{id}")
    public List<Movie> selectFavoriteById(@PathVariable String id){
        QueryWrapper<UserFavorite> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        List<UserFavorite> list = userFavoriteService.list(queryWrapper);
        List<Movie> movies = new ArrayList<>();
        for(UserFavorite cur : list){

        }

        System.out.println(list.size());
        return movies;

    }

}
