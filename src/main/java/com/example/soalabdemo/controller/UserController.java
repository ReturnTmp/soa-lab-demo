package com.example.soalabdemo.controller;

import com.example.soalabdemo.entity.User;
import com.example.soalabdemo.service.UserService;
import com.example.soalabdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//也就是在data里面加link字符串就好,可以使用json和String的转换.
@Api
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    String link;



    @PostMapping("user")
    @ApiOperation(value = "添加用户")
    public Result addUser(User user) {
        Result result = userService.addUser(user);
        String id = "http://localhost:8080/user";
        result.setLink(id);
        return result;
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public Result queryUserById(@PathVariable("id") int userId) {
        Result result = userService.queryUserById(userId);
        String id = "http://localhost:8080/" + "user";
        result.setLink(id);
        return result;
    }

//    @GetMapping("user")
//    @ApiOperation("根据用户姓名获取用户信息")
//    public Result queryUserByName(@RequestParam String username) {
//        return userService.queryUserByName(username);
//    }

    @GetMapping("user")
    @ApiOperation(value = "获取所有用户信息")
    public Result queryUser() {
        return userService.queryAll();
    }

    @PutMapping("user")
    @ApiOperation(value = "修改用户信息")
    public Result modifyUser(User user) {
        Result result = userService.modifyUser(user);
        String id = "http://localhost:8080/" + "user";
        result.setLink(id);
        return result;
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "根据用户id删除用户")
    public Result deleteUserById(@PathVariable("id") int userId) {

        return userService.deleteUserById(userId);
    }
}
