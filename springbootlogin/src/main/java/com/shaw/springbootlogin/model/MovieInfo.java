package com.shaw.springbootlogin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaw
 * @since 2020-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MovieInfo对象", description="")
public class MovieInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "movie_id", type = IdType.ID_WORKER_STR)
    private String movieId;

    private String movieTitle;

    private String releaseDate;

    private String videoReleaseDate;

    private String imdbUrl;

    private String unknown;

    private String action;

    private String adventure;

    private String animation;

    private String children;

    private String comedy;

    private String crime;

    private String documentary;

    private String drama;

    private String fantasy;

    private String filmNoir;

    private String horror;

    private String musical;

    private String mystery;

    private String romance;

    private String sciFi;

    private String thriller;

    private String war;

    private String western;


}
