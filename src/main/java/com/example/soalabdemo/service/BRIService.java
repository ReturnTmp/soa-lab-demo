package com.example.soalabdemo.service;

import com.example.soalabdemo.entity.BorrowReturnInfo;
import com.example.soalabdemo.util.Result;

public interface BRIService {
    /**
     * 添加借还信息
     * @param borrowReturnInfo
     * @return
     */
    Result addBRI(BorrowReturnInfo borrowReturnInfo);

    /**
     * 根据记录id删除借还信息
     * @param recordId
     * @return
     */
    Result deleteBRIByRecordId(int recordId);

    /**
     * 修改借还信息
     * @param borrowReturnInfo
     * @return
     */
    Result modifyBRI(BorrowReturnInfo borrowReturnInfo);

    /**
     * 根据记录id查询借还信息
     * @param recordId
     * @return
     */
    Result queryBRIByRecordId(int recordId);

    /**
     * 根据用户id查询借还信息
     * @param userId
     * @return
     */
    Result queryBRIByUserId(int userId);

    /**
     * 根据物资id查询借还信息
     * @param resourceId
     * @return
     */
    Result queryBRIByResourceId(int resourceId);

    /**
     * 查询所有借还信息
     * @return
     */
    Result queryAll();
}
