package com.example.swagger.controller;

import com.example.swagger.dao.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class HelloController {
    //    @RequestMapping("/hello")  //可以以任何方式提交接口
    @ApiOperation("Post在浏览器访问不到")
    @PostMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation("Get可以在浏览器访问")
    @GetMapping("/hello1")
    public String hello1() {
        return "Hello1 World!";
    }

    @ApiOperation("Hello控制类")
    @PostMapping("/hello2")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", required = true)
    )  //这样参数可以不必输
    public String hello2(String username) {
        return "Hello " + username;
    }

    //注意用@ApiParam参数没有@ResponseBody会报错：TypeError: Failed to execute 'fetch' on 'Window': Request with GET/HEAD method cannot have body.
    @ApiOperation(value = "获取用户信息", notes = "注意问题点")
    @GetMapping("/getUserInfo")
    public User getUserInfo(@ApiParam(name = "username", value = "用户名", required = true) String username, @ApiParam(name = "password", value = "密码") String password) {
        return new User();
    }

    //只要这个实体在请求接口的返回值上（即使是泛型），都能映射到实体项中：
    @PostMapping("/user")
    public User user() {
        return new User();
    }

}
