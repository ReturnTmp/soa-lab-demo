package com.example.soalabdemo.controller;

import com.example.soalabdemo.entity.BorrowReturnInfo;
import com.example.soalabdemo.service.BRIService;
import com.example.soalabdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class BRIController {

    @Autowired
    private BRIService briService;

    @PostMapping("borrowReturnInfo")
    @ApiOperation(value = "添加借还信息")
    public Result addBRI(BorrowReturnInfo borrowReturnInfo) {
        return briService.addBRI(borrowReturnInfo);
    }

    @DeleteMapping("borrowReturnInfo/{id}")
    @ApiOperation(value = "根据记录id删除物资")
    public Result deleteBRIByRecordId(@PathVariable("id") int recordId) {
        return briService.deleteBRIByRecordId(recordId);
    }

    @PutMapping("borrowReturnInfo")
    @ApiOperation("修改物资信息")
    public Result modifyBRI(BorrowReturnInfo borrowReturnInfo) {
        return briService.modifyBRI(borrowReturnInfo);
    }

    @GetMapping("borrowReturnInfo/user/{id}")
    @ApiOperation(value = "根据用户id查询借还信息")
    public Result queryBRIByUserId(@PathVariable("id") int userId) {
        return briService.queryBRIByUserId(userId);
    }

    @GetMapping("borrowReturnInfo/resource/{id}")
    @ApiOperation(value = "根据物资id查询借还信息")
    public Result queryBRIByResourceId(@PathVariable("id") int resourceId) {
        return briService.queryBRIByResourceId(resourceId);
    }

    @GetMapping("borrowReturnInfo/{id}")
    @ApiOperation(value = "根据记录id查询借还信息")
    public Result queryBRIByRecordId(@PathVariable("id") int recordId) {
        return briService.queryBRIByRecordId(recordId);
    }

    @GetMapping("borrowReturnInfo")
    @ApiOperation(value = "查询所有借还记录")
    public Result queryAll() {
        return briService.queryAll();
    }
}
