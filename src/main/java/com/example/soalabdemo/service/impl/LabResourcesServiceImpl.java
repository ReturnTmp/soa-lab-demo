package com.example.soalabdemo.service.impl;

import com.example.soalabdemo.entity.LabResources;
import com.example.soalabdemo.persistence.LabResourcesRepository;
import com.example.soalabdemo.service.LabResourcesService;
import com.example.soalabdemo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LabResourcesServiceImpl implements LabResourcesService {

    @Autowired
    private LabResourcesRepository labResourcesRepository;

    @Override
    public Result addLabResources(LabResources labResources) {
        // 判断该该物资是否在数据库已存在
        if (labResourcesRepository.getLabResourcesByResourceName(labResources.getResourceName()) != null) {
            return new Result("该已存在！");
        }
        labResources.setCreated(new Date(System.currentTimeMillis()));
        labResources.setLinkUrl("http://localhost:8080/user");
        labResourcesRepository.save(labResources);
        return new Result("添加物资成功！");
    }

    @Override
    public Result queryLabResourceById(int resourceId) {
        Optional<LabResources> labResources = labResourcesRepository.findById(resourceId);
        // 如果物资存在
        if (labResources.isPresent()) {
            return new Result(labResources);
        }
        return new Result("该物资不存在！");
    }

    @Override
    public Result queryLabResourceByName(String resourceName) {
        LabResources labResources = labResourcesRepository.getLabResourcesByResourceName(resourceName);
        if(labResources != null) {
            return new Result(labResources);
        }
        return new Result("无此物资！");
    }

    @Override
    public Result queryAll() {
        List<LabResources> labResources = labResourcesRepository.findAll();
        if (labResources.size() < 1) {
            return new Result("无物资！");
        }
        return new Result(labResources);
    }

    @Override
    public Result modifyResource(LabResources labResources) {
        LabResources queryLabResource = labResourcesRepository.getLabResourcesByResourceName(labResources.getResourceName());
        // 如果物资存在
        if (queryLabResource.getResourceName() != null) {
            queryLabResource.setQuantity(labResources.getQuantity());
            queryLabResource.setUnit(labResources.getUnit());
            queryLabResource.setLinkUrl(labResources.getLinkUrl());
            labResourcesRepository.save(queryLabResource);
            return new Result("修改成功！");
        }
        return new Result("系统出错！");
    }

    @Override
    public Result deleteResourceById(int resourceId) {
        Optional<LabResources> labResources = labResourcesRepository.findById(resourceId);
        // 如果物资存在
        if (labResources.isPresent()) {
            labResourcesRepository.deleteById(resourceId);
            return new Result("删除成功！");
        }
        return new Result("该物资不存在！");
    }
}
