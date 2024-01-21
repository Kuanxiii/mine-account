CREATE TABLE `billing_accounts`
(
    id INTEGER NOT NULL AUTO_INCREMENT COMMENT '主键' ,
    day_no INTEGER NOT NULL COMMENT '日偏移量',
    week_no INTEGER NOT NULL COMMENT '周偏移量',
    mouth_no INTEGER NOT NULL COMMENT '月偏移量',
    stat VARCHAR(255) NOT NULL COMMENT '当日状态',
    amount DECIMAL NOT NULL COMMENT '金额',
    use_in VARCHAR(255) NOT NULL COMMENT '使用于某处',
    main_attribute INTEGER NOT NULL COMMENT '主属性',
    attributes VARCHAR(255) COMMENT '其他属性',
    remark VARCHAR(255) COMMENT '备注',
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '账单表';

CREATE TABLE `account_attribute`
(
    id INTEGER NOT NULL AUTO_INCREMENT COMMENT '主键',
    rigid_demand INTEGER NOT NULL COMMENT '是否刚需',
    attribute_level INTEGER NOT NULL COMMENT '属性等级',
    sup_attribute_id INTEGER COMMENT '上级属性',
    sup_attribute_name VARCHAR(255) COMMENT '上级属性名',
    attribute_name VARCHAR(255) NOT NULL UNIQUE COMMENT '属性名',
    attribute_desc VARCHAR(255) COMMENT '备注',
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '账单表';
