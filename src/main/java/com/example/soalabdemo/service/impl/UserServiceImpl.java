package com.example.soalabdemo.service.impl;

import com.example.soalabdemo.entity.User;
import com.example.soalabdemo.persistence.UserRepository;
import com.example.soalabdemo.service.UserService;
import com.example.soalabdemo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result addUser(User user) {
        // 判断该用户是否在数据库已存在
        if (userRepository.getUserByUsername(user.getUsername()) != null) {
            return new Result("当前用户已存在！");
        }
        user.setCreated(new Date(System.currentTimeMillis()));
        user.setLinkUrl("http://localhost:8080/labResource");
        User addedUser = userRepository.save(user);
        return new Result("添加员工成功！");
    }

    @Override
    public Result queryUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        // 如果用户存在
        if (user.isPresent()) {
            return new Result(user);
        }
        return new Result("该员工不存在！");
    }

    @Override
    public Result queryUserByName(String username) {
        User user = userRepository.getUserByUsername(username);
        if(user != null) {
            return new Result(user);
        }
        return new Result("无此员工！");
    }

    @Override
    public Result queryAll() {
        List<User> users = userRepository.findAll();
        if (users.size() < 1) {
            return new Result("无员工！");
        }
        return new Result(users);
    }

    @Override
    public Result modifyUser(User user) {
        User queryUser = userRepository.getUserByUsername(user.getUsername());
        // 如果用户存在
        if (queryUser.getUsername() != null) {
            queryUser.setPassword(user.getPassword());
            queryUser.setFullName(user.getFullName());
            queryUser.setContactNumber(user.getContactNumber());
            queryUser.setLinkUrl(user.getLinkUrl());
            userRepository.save(queryUser);
            return new Result("修改成功！");
        }
        return new Result("系统出错！");
    }

    @Override
    public Result deleteUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        // 如果用户存在
        if (user.isPresent()) {
            userRepository.deleteById(userId);
            return new Result("删除成功！");
        }
        return new Result("该用户不存在！");
    }
}
