package com.example.soalabdemo.service;

import com.example.soalabdemo.entity.LabResources;
import com.example.soalabdemo.util.Result;

public interface LabResourcesService {
    /**
     * 添加物资
     * @param labResources
     * @return
     */
    Result addLabResources(LabResources labResources);

    /**
     * 根据物资id查询物资
     * @param resourceId
     * @return
     */
    Result queryLabResourceById(int resourceId);

    /**
     * 根据物资名称查询物资信息
     * @param resourceName
     * @return
     */
    Result queryLabResourceByName(String resourceName);

    /**
     * 查询所有物资
     * @return
     */
    Result queryAll();

    /**
     * 修改物资信息
     * @param labResources
     * @return
     */
    Result modifyResource(LabResources labResources);

    /**
     * 根据id删除物资
     * @param resourceId
     * @return
     */
    Result deleteResourceById(int resourceId);
}
