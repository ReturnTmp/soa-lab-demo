package com.example.soalabdemo.controller;

import com.example.soalabdemo.entity.LabResources;
import com.example.soalabdemo.service.LabResourcesService;
import com.example.soalabdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class LabResourcesController {
    @Autowired
    private LabResourcesService labResourcesService;

    @PostMapping("labResource")
    @ApiOperation(value = "添加物资")
    public Result addLabResource(LabResources labResources) {
        return labResourcesService.addLabResources(labResources);
    }

//    @GetMapping("labResource")
//    @ApiOperation(value = "根据物资名称查询物资")
//    public Result queryLabResourceByName(@RequestParam String resourceName) {
//        return labResourcesService.queryLabResourceByName(resourceName);
//    }

    @GetMapping("labResource/{id}")
    @ApiOperation(value = "根据物资id获取物资信息")
    public Result queryLabResourceById(@PathVariable("id") int resourceId) {
        return labResourcesService.queryLabResourceById(resourceId);
    }

    @GetMapping("labResource")
    @ApiOperation(value = "获取所有物资信息")
    public Result queryLabResources() {
        return labResourcesService.queryAll();
    }

    @PutMapping("labResource")
    @ApiOperation(value = "修改物资信息")
    public Result modifyLabResource(LabResources labResources) {
        return labResourcesService.modifyResource(labResources);
    }

    @DeleteMapping("labResource/{id}")
    @ApiOperation(value = "根据物资id删除物资")
    public Result deleteLabResourceById(@PathVariable("id") int resourceId) {
        return labResourcesService.deleteResourceById(resourceId);
    }
}
