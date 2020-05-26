package com.shaw.springbootlogin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaw.springbootlogin.model.UserFavorite;
import com.shaw.springbootlogin.service.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaw
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/api/favorite")
public class UserFavoriteController {

    @Autowired
    UserFavoriteService userFavoriteService;
    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public String addMovieToFavorite(@RequestBody String json) throws Exception{
        System.out.println(json);
        JsonNode jsonNode = mapper.readTree(json);
        String userId = jsonNode.path("user_id").textValue();
        String movieId = jsonNode.path("movie_id").textValue();
        QueryWrapper<UserFavorite> queryWrapper = new QueryWrapper();
        UserFavorite userFavorite = new UserFavorite(userId, movieId);

        queryWrapper.eq("user_id", userFavorite.getUserId());
        queryWrapper.eq("movie_id", userFavorite.getMovieId());
        try{
            UserFavorite result = userFavoriteService.getOne(queryWrapper);
            if(result!=null){
                return "已经收藏过本电影！";
            } else {
                userFavoriteService.save(userFavorite);
                return "成功加入收藏！";
            }
        } catch (Exception e){
            e.printStackTrace();
            userFavoriteService.save(userFavorite);
            return "成功加入收藏！";
        }
    }

}

