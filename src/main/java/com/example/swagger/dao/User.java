package com.example.swagger.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class User {
    @ApiModelProperty(value = "用户名",position = 1)
    public String username;
    @ApiModelProperty(value = "密码",position = 2)
    public String password;
}
