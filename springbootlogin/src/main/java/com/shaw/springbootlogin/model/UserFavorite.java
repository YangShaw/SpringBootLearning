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
@ApiModel(value="UserFavorite对象", description="")
public class UserFavorite implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String movieId;

    public UserFavorite(String userId, String movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }
}
