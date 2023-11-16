package com.example.soalabdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "lab_resources")
public class LabResources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceId;

    @Column(name = "resource_name")
    private String resourceName;

    private int quantity;

    private String unit;

    // TODO: 超链接待修改
    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "created_at")
    private Date created;
}
