# HW6

```sql
# 创建数据库
CREATE DATABASE new_database_name;
# 删除数据库
DROP DATABASE old_database_name;
# 显示table
USE new_database_name;
SHOW TABLES;
SELECT * FROM some_table;
# 创建表
CREATE TABLE `ChuwaTest`.`oms_order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT,
  `order_sn` VARCHAR(64),
  `create_time` DATETIME,
  `member_username` VARCHAR(64),
  `total_amount` DECIMAL(10, 2),
  `pay_amount` DECIMAL(10, 2),
  `freight_amount` DECIMAL(10, 2),
  `pay_type` INT(1),
  `source_type` INT(1),
  `status` INT(1),
  `order_type` INT(1),
  `delivery_company` VARCHAR(64),
  `delivery_sn` VARCHAR(64),
  `auto_confirm_day` INT,
  `bill_type` INT(1),
  `receiver_name` VARCHAR(100),
  `receiver_phone` VARCHAR(32),
  `receiver_post_code` VARCHAR(32),
  `receiver_province` VARCHAR(32),
  `receiver_city` VARCHAR(32),
  `receiver_region` VARCHAR(32),
  `receiver_detail_address` VARCHAR(200),
  `note` VARCHAR(500),
  `confirm_status` INT(1),
  `delete_status` INT(1),
  `payment_time` DATETIME,
  `delivery_time` DATETIME,
  `receive_time` DATETIME,
  `comment_time` DATETIME,
  `modify_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_order_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT,
  `order_sn` VARCHAR(64),
  `product_id` BIGINT,
  `product_pic` VARCHAR(500),
  `product_name` VARCHAR(200),
  `product_brand` VARCHAR(200),
  `product_sn` VARCHAR(64),
  `product_price` DECIMAL(10, 2),
  `product_quantity` INT,
  `product_sku_id` BIGINT,
  `product_sku_code` VARCHAR(50),
  `product_category_id` BIGINT,
  `sp1` VARCHAR(100),
  `sp2` VARCHAR(100),
  `sp3` VARCHAR(100),
  `product_attr` VARCHAR(500),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_order_operate_history` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT,
  `operate_man` VARCHAR(100),
  `create_time` DATETIME,
  `order_status` INT(1),
  `note` VARCHAR(500),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_order_setting`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `normal_order_overtime` INT,
  `confirm_overtime` INT,
  `finish_overtime` INT,
  `comment_overtime` INT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_order_return_apply`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT,
  `company_address_id` BIGINT,
  `product_id` BIGINT,
  `order_sn` VARCHAR(64),
  `create_time` DATETIME,
  `member_username` VARCHAR(64),
  `return_amount` DECIMAL(10, 2),
  `return_name` VARCHAR(100),
  `return_phone` VARCHAR(100),
  `status` INT(1),
  `handle_time` DATETIME,
  `product_pic` VARCHAR(500),
  `product_name` VARCHAR(200),
  `product_brand` VARCHAR(200),
  `product_attr` VARCHAR(500),
  `product_count` INT,
  `product_price` DECIMAL(10, 2),
  `product_real_price` DECIMAL(10, 2),
  `reason` VARCHAR(200),
  `description` VARCHAR(500),
  `proof_pics` VARCHAR(1000),
  `handle_note` VARCHAR(500),
  `handle_man` VARCHAR(100),
  `receive_man` VARCHAR(100),
  `receive_time` DATETIME,
  `receive_note` VARCHAR(500),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_company_address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `address_name` VARCHAR(200),
  `send_status` INT(1),
  `receive_status` INT(1),
  `name` VARCHAR(64),
  `phone` VARCHAR(64),
  `province` VARCHAR(64),
  `city` VARCHAR(64),
  `region` VARCHAR(64),
  `detail_address` VARCHAR(200),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_order_return_reason` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100),
  `sort` INT,
  `status` INT(1),
  `create_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ChuwaTest`.`oms_cart_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT,
  `product_sku_id` BIGINT,
  `member_id` BIGINT,
  `quantity` INT,
  `price` DECIMAL(10, 2),
  `sp1` VARCHAR(200),
  `sp2` VARCHAR(200),
  `sp3` VARCHAR(200),
  `product_pic` VARCHAR(1000),
  `product_name` VARCHAR(500),
  `product_brand` VARCHAR(200),
  `product_sn` VARCHAR(200),
  `product_sub_title` VARCHAR(500),
  `product_sku_code` VARCHAR(200),
  `member_nickname` VARCHAR(500),
  `create_date` DATETIME,
  `modify_date` DATETIME,
  `delete_status` INT(1),
  `product_category_id` BIGINT,
  `product_attr` VARCHAR(500),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```