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

    String link;

    @PostMapping("labResource")
    @ApiOperation(value = "添加物资")
    public Result addLabResource(LabResources labResources) {
        Result result = labResourcesService.addLabResources(labResources);
        link = "http://localhost:8080/labResource";
        result.setLink(link);
        return result;
    }

//    @GetMapping("labResource")
//    @ApiOperation(value = "根据物资名称查询物资")
//    public Result queryLabResourceByName(@RequestParam String resourceName) {
//        return labResourcesService.queryLabResourceByName(resourceName);
//    }

    @GetMapping("labResource/{id}")
    @ApiOperation(value = "根据物资id获取物资信息")
    public Result queryLabResourceById(@PathVariable("id") int resourceId) {
        Result result = labResourcesService.queryLabResourceById(resourceId);
        link = "http://localhost:8080/labResource";
        result.setLink(link);
        return result;
    }

    @GetMapping("labResource")
    @ApiOperation(value = "获取所有物资信息")
    public Result queryLabResources() {
        Result result =  labResourcesService.queryAll();
        link = "http://localhost:8080/labResource";
        result.setLink(link);
        return result;
    }

    @PutMapping("labResource")
    @ApiOperation(value = "修改物资信息")
    public Result modifyLabResource(LabResources labResources) {
        Result result =  labResourcesService.modifyResource(labResources);
        link = "http://localhost:8080/labResource/{id}";
        result.setLink(link);
        return result;
    }

    @DeleteMapping("labResource/{id}")
    @ApiOperation(value = "根据物资id删除物资")
    public Result deleteLabResourceById(@PathVariable("id") int resourceId) {
        return labResourcesService.deleteResourceById(resourceId);
    }
}
