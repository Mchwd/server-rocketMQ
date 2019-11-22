DROP TABLE IF EXISTS user;
CREATE TABLE `user`
(
    `uid`        INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '用户Id',
    `username`   VARCHAR(100) NOT NULL COMMENT '用户名',
    `password`   VARCHAR(128) NOT NULL COMMENT '密码',
    `phone`      VARCHAR(11)  DEFAULT NULL COMMENT '手机',
    `sex`        TINYINT(1)   DEFAULT 1 COMMENT '性别 1 表示男 0 表示女',
    `email`      VARCHAR(100) NOT NULL COMMENT '邮箱',
    `mark`       VARCHAR(100) DEFAULT NULL COMMENT '备注',
    `last_login` TIMESTAMP    DEFAULT current_timestamp NOT NULL COMMENT '最后一次登录时间',
    `login_ip`   VARCHAR(30)  DEFAULT NULL COMMENT '登录ip',
    `head`       VARCHAR(100) DEFAULT '/img/default.png' COMMENT '头像图片路径',
    `reg_time`   TIMESTAMP    DEFAULT current_timestamp NOT NULL COMMENT '注册时间',
    `locked`     TINYINT(1)   DEFAULT 0 COMMENT '账号是否被锁定 1 表示未锁定 0 表示锁定',
    UNIQUE KEY `uk_u_name` (`username`),
    UNIQUE KEY `uk_u_phone` (`phone`),
    UNIQUE KEY `uk_u_email` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;