package com.example.soalabdemo.service;

import com.example.soalabdemo.entity.User;
import com.example.soalabdemo.util.Result;

public interface UserService {
    /**
     * 增加一个员工
     * @param user
     * @return
     */
    Result addUser(User user);

    /**
     * 根据员工id查询员工
     * @param userId
     * @return
     */
    Result queryUserById(int userId);

    /**
     * 根据员工姓名查询员工
     * @param username
     * @return
     */
    Result queryUserByName(String username);

    /**
     * 查询所有员工
     * @return
     */
    Result queryAll();

    /**
     * 根据员工id修改员工信息
     * @param user
     * @return
     */
    Result modifyUser(User user);

    /**
     * 根据员工id删除员工
     * @param userId
     * @return
     */
    Result deleteUserById(int userId);
}
