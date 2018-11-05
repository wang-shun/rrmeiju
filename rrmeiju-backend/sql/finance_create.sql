DROP DATABASE IF EXISTS finance;
CREATE DATABASE finance CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci';
USE finance;

-- 合同表
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`
(
	`contract_id` INTEGER NOT NULL AUTO_INCREMENT COMMENT '合同ID',
	`part_a` VARCHAR(100) NOT NULL COMMENT '合同甲方',
	`part_b` VARCHAR(100) NOT NULL COMMENT '合同乙方',
	`begin_time` TIMESTAMP NOT NULL COMMENT '合同生效时间',
	`end_time` TIMESTAMP NOT NULL COMMENT '合同失效时间',
	CONSTRAINT `pk_contract` PRIMARY KEY (contract_id)
) ENGINE=InnoDB AUTO_INCREMENT = 10000000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;