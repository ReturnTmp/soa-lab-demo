package com.example.soalabdemo.service.impl;

import com.example.soalabdemo.entity.BorrowReturnInfo;
import com.example.soalabdemo.persistence.BRIRepository;
import com.example.soalabdemo.service.BRIService;
import com.example.soalabdemo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BRIServiceImpl implements BRIService {

    @Autowired
    private BRIRepository briRepository;

    @Override
    public Result addBRI(BorrowReturnInfo borrowReturnInfo) {
        borrowReturnInfo.setBorrowTime(new Date(System.currentTimeMillis()));
        borrowReturnInfo.setCreated(new Date(System.currentTimeMillis()));
        borrowReturnInfo.setLinkUrl("http://localhost:8080/labResource");
        briRepository.save(borrowReturnInfo);
        return new Result("添加成功！");
    }

    @Override
    public Result deleteBRIByRecordId(int recordId) {
        Optional<BorrowReturnInfo> borrowReturnInfo = briRepository.findById(recordId);
        if (borrowReturnInfo.isPresent()) {
            briRepository.deleteById(recordId);
            return new Result("删除成功！");
        }
        return new Result("无此借还信息！");
    }

    @Override
    public Result modifyBRI(BorrowReturnInfo borrowReturnInfo) {
        Optional<BorrowReturnInfo> queryBorrowReturnInfo = briRepository.findById(borrowReturnInfo.getRecordId());
        // 如果物资存在
        if (queryBorrowReturnInfo.isPresent()) {
            queryBorrowReturnInfo.get().setReturnQuantity(borrowReturnInfo.getReturnQuantity());
            queryBorrowReturnInfo.get().setReturnTime(new Date(System.currentTimeMillis()));
            briRepository.save(queryBorrowReturnInfo.get());
            return new Result("修改成功！");
        }
        return new Result("系统出错！");
    }

    @Override
    public Result queryBRIByRecordId(int recordId) {
        Optional<BorrowReturnInfo> borrowReturnInfo = briRepository.findById(recordId);
        return borrowReturnInfo.map(Result::new).orElseGet(() -> new Result("无此借还信息！"));
    }

    @Override
    public Result queryBRIByUserId(int userId) {
        List<BorrowReturnInfo> borrowReturnInfos = briRepository.getBorrowReturnInfoByUserId(userId);
        if(borrowReturnInfos.size() > 0) {
            return new Result(borrowReturnInfos);
        }
        return new Result("无该用户的借还信息！");
    }

    @Override
    public Result queryBRIByResourceId(int resourceId) {
        List<BorrowReturnInfo> borrowReturnInfos = briRepository.getBorrowReturnInfoByResourceId(resourceId);
        if(borrowReturnInfos.size() > 0) {
            return new Result(borrowReturnInfos);
        }
        return new Result("无该物资的借还信息！");
    }

    @Override
    public Result queryAll() {
        List<BorrowReturnInfo> borrowReturnInfos = briRepository.findAll();
        if (borrowReturnInfos.size() > 0) {
            return new Result(borrowReturnInfos);
        }
        return new Result("无借还信息！");
    }
}
