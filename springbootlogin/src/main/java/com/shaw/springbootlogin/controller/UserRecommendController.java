package com.shaw.springbootlogin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaw.springbootlogin.model.MovieAndRating;
import com.shaw.springbootlogin.model.MovieInfo;
import com.shaw.springbootlogin.model.UserRating;
import com.shaw.springbootlogin.model.UserRecommend;
import com.shaw.springbootlogin.service.MovieInfoService;
import com.shaw.springbootlogin.service.UserRatingService;
import com.shaw.springbootlogin.service.UserRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaw
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/api/recommend")
public class UserRecommendController {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserRatingService userRatingService;

    @Autowired
    UserRecommendService userRecommendService;

    @Autowired
    MovieInfoService movieInfoService;

    @PostMapping(value = "top")
    public List<MovieAndRating> selectRecordsByUserid(@RequestBody String json)throws Exception{
        System.out.println(json);
        JsonNode jsonNode = mapper.readTree(json);
        String userId = jsonNode.path("userid").textValue();

        QueryWrapper<UserRecommend> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);

        UserRecommend userRecommend = userRecommendService.getOne(queryWrapper);

        List<MovieAndRating> result2 = new ArrayList<>();

        QueryWrapper<MovieInfo> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("movie_id", userRecommend.getMovie1());
        MovieInfo movie1 = movieInfoService.getOne(queryWrapper1);
        MovieAndRating movieAndRating1 = new MovieAndRating(
                movie1.getMovieId(),
                movie1.getMovieTitle(),
                movie1.getReleaseDate(),
                -1
        );
        result2.add(movieAndRating1);

        QueryWrapper<MovieInfo> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("movie_id", userRecommend.getMovie2());
        MovieInfo movie2 = movieInfoService.getOne(queryWrapper2);
        MovieAndRating movieAndRating2 = new MovieAndRating(
                movie2.getMovieId(),
                movie2.getMovieTitle(),
                movie2.getReleaseDate(),
                -1
        );
        result2.add(movieAndRating2);

        QueryWrapper<MovieInfo> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("movie_id", userRecommend.getMovie3());
        MovieInfo movie3 = movieInfoService.getOne(queryWrapper3);
        MovieAndRating movieAndRating3 = new MovieAndRating(
                movie3.getMovieId(),
                movie3.getMovieTitle(),
                movie3.getReleaseDate(),
                -1
        );
        result2.add(movieAndRating3);

        QueryWrapper<MovieInfo> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.eq("movie_id", userRecommend.getMovie4());
        MovieInfo movie4 = movieInfoService.getOne(queryWrapper4);
        MovieAndRating movieAndRating4 = new MovieAndRating(
                movie4.getMovieId(),
                movie4.getMovieTitle(),
                movie4.getReleaseDate(),
                -1
        );
        result2.add(movieAndRating4);

        QueryWrapper<MovieInfo> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.eq("movie_id", userRecommend.getMovie5());
        MovieInfo movie5 = movieInfoService.getOne(queryWrapper5);
        MovieAndRating movieAndRating5 = new MovieAndRating(
                movie5.getMovieId(),
                movie5.getMovieTitle(),
                movie5.getReleaseDate(),
                -1
        );
        result2.add(movieAndRating5);

        System.out.println(result2.size());
        return result2;
    }

}

