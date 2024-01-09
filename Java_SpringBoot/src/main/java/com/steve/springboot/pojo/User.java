package com.steve.springboot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: STEVE
 * @Description: 实体类 - User
 * @since: 2024/1/8
 */
@ApiModel("用户实体")
public class User {

    @ApiModelProperty("用户名")
    public String username;

    @ApiModelProperty("密码")
    public String password;

}
