package com.example.soalabdemo.controller;

import com.example.soalabdemo.entity.User;
import com.example.soalabdemo.service.UserService;
import com.example.soalabdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    @ApiOperation(value = "添加用户")
    public Result addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public Result queryUserById(@PathVariable("id") int userId) {
        return userService.queryUserById(userId);
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
        return userService.modifyUser(user);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "根据用户id删除用户")
    public Result deleteUserById(@PathVariable("id") int userId) {
        return userService.deleteUserById(userId);
    }
}
