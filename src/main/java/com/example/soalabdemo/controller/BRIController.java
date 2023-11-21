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

    String link;

    @PostMapping("borrowReturnInfo")
    @ApiOperation(value = "添加借还信息")
    public Result addBRI(BorrowReturnInfo borrowReturnInfo) {

        Result result =  briService.addBRI(borrowReturnInfo);
        link = "http://localhost:8080/borrowReturnInfo/user/{id}";
        result.setLink(link);
        return result;
    }

    @DeleteMapping("borrowReturnInfo/{id}")
    @ApiOperation(value = "根据记录id删除物资")
    public Result deleteBRIByRecordId(@PathVariable("id") int recordId) {
        Result result =  briService.deleteBRIByRecordId(recordId);
        link = "http://localhost:8080/borrowReturnInfo";
        result.setLink(link);
        return result;
    }

    @PutMapping("borrowReturnInfo")
    @ApiOperation("修改物资信息")
    public Result modifyBRI(BorrowReturnInfo borrowReturnInfo) {

        Result result =  briService.modifyBRI(borrowReturnInfo);
        link = "http://localhost:8080/borrowReturnInfo/{id}";
        result.setLink(link);
        return result;
    }
//load here
    @GetMapping("borrowReturnInfo/user/{id}")
    @ApiOperation(value = "根据用户id查询借还信息")
    public Result queryBRIByUserId(@PathVariable("id") int userId) {
        Result result =  briService.queryBRIByUserId(userId);
        link = "http://localhost:8080/borrowReturnInfo/resource/{id}";
        result.setLink(link);
        return result;
    }

    @GetMapping("borrowReturnInfo/resource/{id}")
    @ApiOperation(value = "根据物资id查询借还信息")
    public Result queryBRIByResourceId(@PathVariable("id") int resourceId) {
        Result result =  briService.queryBRIByResourceId(resourceId);
        link = "http://localhost:8080/borrowReturnInfo/user/{id}";
        result.setLink(link);
        return result;
    }

    @GetMapping("borrowReturnInfo/{id}")
    @ApiOperation(value = "根据记录id查询借还信息")
    public Result queryBRIByRecordId(@PathVariable("id") int recordId) {
        Result result =  briService.queryBRIByRecordId(recordId);
        link = "http://localhost:8080/borrowReturnInfo/{id}";
        result.setLink(link);
        return result;
    }

    @GetMapping("borrowReturnInfo")
    @ApiOperation(value = "查询所有借还记录")
    public Result queryAll() {
        return briService.queryAll();
    }
}
