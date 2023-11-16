package com.example.soalabdemo.persistence;

import com.example.soalabdemo.entity.BorrowReturnInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BRIRepository extends JpaRepository<BorrowReturnInfo, Integer> {
    List<BorrowReturnInfo> getBorrowReturnInfoByUserId(int userId);
    List<BorrowReturnInfo> getBorrowReturnInfoByResourceId(int resourceId);
}
