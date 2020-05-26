package com.shaw.springbootlogin.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaw.springbootlogin.model.Movie;
import com.shaw.springbootlogin.model.MovieAndRating;
import com.shaw.springbootlogin.model.MovieInfo;
import com.shaw.springbootlogin.model.UserRating;
import com.shaw.springbootlogin.service.MovieInfoService;
import com.shaw.springbootlogin.service.UserRatingService;
import com.shaw.springbootlogin.util.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/api/rating")
public class UserRatingController {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserRatingService userRatingService;

    @Autowired
    MovieInfoService movieInfoService;

    @PostMapping(value = "favorite")
    public List<MovieAndRating> selectRecordsByUserid(@RequestBody String json)throws Exception{
        System.out.println(json);
        JsonNode jsonNode = mapper.readTree(json);
        String userId = jsonNode.path("userid").textValue();

        QueryWrapper<UserRating> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);

        List<UserRating> result = userRatingService.list(queryWrapper);
        System.out.println(result.size());


        List<MovieAndRating> result2 = new ArrayList<>();

        for(UserRating cur:result){
            QueryWrapper<MovieInfo> queryWrapper2 = new QueryWrapper<>();
            //System.out.println(cur.getItemid());
            queryWrapper2.eq("movie_id", cur.getItemid());
            MovieInfo movie = movieInfoService.getOne(queryWrapper2);
            //System.out.println(movie);
            //MovieInfo movie = SqlUtils.getMovieInfoById(cur.getItemid());
            MovieAndRating movieAndRating = new MovieAndRating(
                    movie.getMovieId(),
                    movie.getMovieTitle(),
                    movie.getReleaseDate(),
                    cur.getRating()
            );
            result2.add(movieAndRating);
        }

        System.out.println(result2.size());
        return result2;
    }
}

