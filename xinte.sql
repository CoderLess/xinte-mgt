/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 8.131.95.28:3306
 Source Schema         : xinte

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 01/01/2021 01:01:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_base
-- ----------------------------
DROP TABLE IF EXISTS `admin_base`;
CREATE TABLE `admin_base` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `mobile` VARCHAR ( 32 ) NOT NULL DEFAULT '' COMMENT '手机号',
    `password` VARCHAR ( 32 ) NOT NULL DEFAULT '' COMMENT '密码',
    `name` VARCHAR ( 32 ) NOT NULL DEFAULT '' COMMENT '姓名',
    `role_id` BIGINT NOT NULL DEFAULT '0' COMMENT '角色id',
    `disable` TINYINT NOT NULL DEFAULT '0' COMMENT '是否禁用 0:否，1:是',
    `create_time` BIGINT NOT NULL DEFAULT '0' COMMENT '创建时间',
    `creator_id` BIGINT NOT NULL DEFAULT '0' COMMENT '创建人',
    `last_access` BIGINT NOT NULL DEFAULT '0' COMMENT '最后更新时间',
    PRIMARY KEY ( `id` ),
    UNIQUE KEY `ind_admin_base_mobile` ( `mobile` ) COMMENT '手机号唯一索引'
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '后台人员基本信息';
-- ----------------------------
-- Records of admin_base
-- ----------------------------

-- ----------------------------
-- Table structure for authority_base
-- ----------------------------
DROP TABLE IF EXISTS `authority_base`;
CREATE TABLE `authority_base`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限名',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '接口',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority_base
-- ----------------------------

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '管理员id',
  `login_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '登录时间',
  `ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '登入终端ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录日志信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_base
-- ----------------------------
DROP TABLE IF EXISTS `medicine_base`;
CREATE TABLE `medicine_base`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编号',
  `factory_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '厂家',
  `spec` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '规格',
  `number` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '数量',
  `purchase_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '进价',
  `selling_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '售价',
  `creator_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新人',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_base
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_check_in_out
-- ----------------------------
DROP TABLE IF EXISTS `medicine_check_in_out`;
CREATE TABLE `medicine_check_in_out`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `medicine_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药品id',
  `number` decimal(10, 0) NOT NULL DEFAULT 0 COMMENT '入库数量',
  `prescription_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药方id',
  `type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '类型 1：入库 2：出库',
  `admin_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '操作人id',
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出库入库信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_check_in_out
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_modify_log
-- ----------------------------
DROP TABLE IF EXISTS `medicine_modify_log`;
CREATE TABLE `medicine_modify_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `medicinal_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药品id',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编号',
  `factory_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '厂家',
  `spec` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '规格',
  `number` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '数量',
  `purchase_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '进价',
  `selling_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '售价',
  `creator_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新人',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `record_create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品修改历史信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_modify_log
-- ----------------------------

-- ----------------------------
-- Table structure for medicine_store
-- ----------------------------
DROP TABLE IF EXISTS `medicine_store`;
CREATE TABLE `medicine_store`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `medicine_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药品id',
  `number` decimal(20, 2) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药品仓库信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_store
-- ----------------------------

-- ----------------------------
-- Table structure for prescription_base
-- ----------------------------
DROP TABLE IF EXISTS `prescription_base`;
CREATE TABLE `prescription_base`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `admin_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '医师',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '会员',
  `medication_time_start` bigint(0) NOT NULL DEFAULT 0 COMMENT '用药开始时间',
  `medication_time_end` bigint(0) NOT NULL DEFAULT 0 COMMENT '用药结束时间',
  `pathogeny` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '病因',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药方基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription_base
-- ----------------------------

-- ----------------------------
-- Table structure for prescription_medicine
-- ----------------------------
DROP TABLE IF EXISTS `prescription_medicine`;
CREATE TABLE `prescription_medicine`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prescription_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药方id',
  `medicinal_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '药品id',
  `sold` tinyint(0) NOT NULL DEFAULT 1 COMMENT '售出 0:否，1:是',
  `number` decimal(20, 2) NOT NULL DEFAULT 1.00 COMMENT '售出数量',
  `selling_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '售出价格',
  `purchase_price` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '药品进价',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '药方-药品基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription_medicine
-- ----------------------------

-- ----------------------------
-- Table structure for role_base
-- ----------------------------
DROP TABLE IF EXISTS `role_base`;
CREATE TABLE `role_base`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '角色名',
  `authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_base
-- ----------------------------

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `mobile` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `sex` tinyint(0) NOT NULL DEFAULT 1 COMMENT '性别 1：男 2：女',
  `birthday` bigint(0) NOT NULL DEFAULT 0 COMMENT '出生日期',
  `disable` bigint(0) NOT NULL DEFAULT 0 COMMENT '禁用用户 0:否，1:是',
  `create_time` bigint(0) NOT NULL COMMENT '创建时间',
  `admin_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_base
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
