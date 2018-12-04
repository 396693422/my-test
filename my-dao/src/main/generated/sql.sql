CREATE TABLE `mytest`.`t_order`(
  `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `address` VARCHAR(256) NOT NULL COMMENT '地址',
  `price` DECIMAL(8,2) NOT NULL COMMENT '订单价格',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  INDEX `idex_user_id` (`user_id`),
  INDEX `idex_create_time` (`create_time`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci
  COMMENT='订单表';

CREATE TABLE `mytest`.`t_order_item`(
  `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
  `goods_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
  `single_price` DECIMAL(7,2) NOT NULL COMMENT '商品单价',
  `goods_num` INT(11) NOT NULL COMMENT '商品数量',
  `goods_price` DECIMAL(8,2) NOT NULL COMMENT '商品价格',
  INDEX `idx_order_id` (`order_id`)
)
  COMMENT='订单项目表';

