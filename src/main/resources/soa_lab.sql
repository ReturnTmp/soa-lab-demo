-- 操作人员表 (users)
CREATE TABLE users
(
    user_id        INT AUTO_INCREMENT COMMENT '用户ID, 主键',
    username       VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名, 唯一且不能为空',
    password       VARCHAR(100)       NOT NULL COMMENT '密码, 不能为空',
    full_name      VARCHAR(100)       NOT NULL COMMENT '姓名, 不能为空',
    contact_number VARCHAR(15) COMMENT '联系方式',
    link_url       VARCHAR(100)                COMMENT '关联url',
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间, 默认为当前时间戳',
    PRIMARY KEY (user_id)
);

-- 实验室物资表 (lab_resources)
CREATE TABLE lab_resources
(
    resource_id   INT AUTO_INCREMENT COMMENT '物资ID, 主键',
    resource_name VARCHAR(100) UNIQUE NOT NULL COMMENT '物资名称, 唯一且不能为空',
    quantity      INT                 NOT NULL COMMENT '数量, 不能为空',
    unit          VARCHAR(20) COMMENT '单位',
    link_url       VARCHAR(100)                COMMENT '关联url',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间, 默认为当前时间戳',
    PRIMARY KEY (resource_id)
);

-- 借用/归还信息表 (borrow_return_info)
CREATE TABLE borrow_return_info
(
    record_id       INT AUTO_INCREMENT COMMENT '记录ID, 主键',
    user_id         INT COMMENT '用户ID, 外键关联到用户表',
    resource_id     INT COMMENT '物资ID, 外键关联到物资表',
    borrow_quantity INT COMMENT '借用数量',
    return_quantity INT COMMENT '归还数量',
    borrow_time     TIMESTAMP COMMENT '借用时间',
    return_time     TIMESTAMP COMMENT '归还时间',
    link_url       VARCHAR(100)                COMMENT '关联url',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间, 默认为当前时间戳',
    PRIMARY KEY (record_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (resource_id) REFERENCES lab_resources (resource_id)
);

