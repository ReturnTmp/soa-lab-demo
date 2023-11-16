package com.example.soalabdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "borrow_return_info")
public class BorrowReturnInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recordId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "resource_id")
    private int resourceId;

    @Column(name = "borrow_quantity")
    private int borrowQuantity;

    @Column(name = "return_quantity")
    private int returnQuantity;

    @Column(name = "borrow_time")
    private Date borrowTime;

    @Column(name = "return_time")
    private Date returnTime;

    // TODO: 超链接待修改
    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "created_at")
    private Date created;
}
