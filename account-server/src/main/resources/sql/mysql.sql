CREATE TABLE economic_attributes (
    economic_attribute_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '经济属性ID',
    user_id INT COMMENT '用户id',
    attribute_name VARCHAR(255) NOT NULL COMMENT '属性名称',
    attribute_desc VARCHAR(255) COMMENT '属性描述',
    rigid_demand TINYINT(1) NOT NULL COMMENT '是否刚需（0:非刚需, 1:刚需）',
    remark VARCHAR(255) COMMENT '备注',
    insert_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    CONSTRAINT uk_attribute_user UNIQUE (attribute_name, user_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '经济属性列表';

CREATE TABLE purpose_attributes (
    purpose_attribute_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用途属性ID',
    user_id INT COMMENT '用户id',
    attribute_name VARCHAR(255) NOT NULL COMMENT '属性名称',
    attribute_desc VARCHAR(255) COMMENT '属性描述',
    remark VARCHAR(255) COMMENT '备注',
    insert_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    CONSTRAINT uk_attribute_user UNIQUE (attribute_name, user_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用途属性列表';


CREATE TABLE bills (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT COMMENT '用户id',
    day_no INT NOT NULL COMMENT '日偏移量',
    week_no INT NOT NULL COMMENT '周偏移量',
    mouth_no INT NOT NULL COMMENT '月偏移量',
    stat VARCHAR(255) NOT NULL COMMENT '当日状态',
    amount DECIMAL(10, 2) NOT NULL COMMENT '金额',
    use_in VARCHAR(255) COMMENT '使用与某处',
    economic_attribute_id INT COMMENT '外键：主属性表economic_attribute_id（经济属性一对一）',
    remark VARCHAR(255) COMMENT '备注',
    insert_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (economic_attribute_id) REFERENCES economic_attributes(economic_attribute_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '账单表';

CREATE TABLE bill_attribute_relation (
     id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
     bill_id INT NOT NULL COMMENT '账单ID',
     purpose_attribute_id INT NOT NULL COMMENT '属性ID',
     insert_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
     update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     FOREIGN KEY (bill_id) REFERENCES bills(bill_id),
     FOREIGN KEY (purpose_attribute_id) REFERENCES purpose_attributes(purpose_attribute_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '账单属性关系表';