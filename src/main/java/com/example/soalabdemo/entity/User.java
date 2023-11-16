package com.example.soalabdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "contact_number")
    private String contactNumber;

    // TODO: 超链接待修改
    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "created_at")
    private Date created;
}
