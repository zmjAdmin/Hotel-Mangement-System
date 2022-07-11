/*
 Navicat Premium Data Transfer

 Source Server         : blog-db
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.216.111:3306
 Source Schema         : hotel2

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 11/07/2022 19:11:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest`  (
  `guest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾客ID',
  `guest_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客姓名',
  `guest_gander` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客性别',
  `guest_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客身份证号码',
  `guest_phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客手机号码',
  `guest_del` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`guest_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入住记录ID',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '房间ID',
  `enter_time` datetime(6) NULL DEFAULT NULL COMMENT '入住时间',
  `exit_time` datetime(6) NULL DEFAULT NULL COMMENT '离开时间',
  `booking_time` datetime(6) NULL DEFAULT NULL COMMENT '预定时间',
  `booking_duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预计居住时长',
  `cost` double(10, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `record_del` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `room_id`(`room_id`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入住记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for record_guest
-- ----------------------------
DROP TABLE IF EXISTS `record_guest`;
CREATE TABLE `record_guest`  (
  `record_guest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `record_id` int(11) NULL DEFAULT NULL COMMENT '入住记录ID',
  `guest_id` int(11) NULL DEFAULT NULL COMMENT '顾客ID',
  PRIMARY KEY (`record_guest_id`) USING BTREE,
  INDEX `record_id`(`record_id`) USING BTREE,
  INDEX `guest_id`(`guest_id`) USING BTREE,
  CONSTRAINT `record_guest_ibfk_1` FOREIGN KEY (`record_id`) REFERENCES `record` (`record_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_guest_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入住记录-顾客' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间ID',
  `room_no` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
  `room_type_id` int(11) NULL DEFAULT NULL COMMENT '房间类型ID',
  `room_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间图片URL',
  `room_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '空房' COMMENT '房间状态，默认为“空房”',
  `room_del` int(255) NULL DEFAULT 0 COMMENT '是否已删除，默认为0，0为没删除',
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `room_type_id`(`room_type_id`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间类型ID',
  `room_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型名字',
  `room_type_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型描述',
  `day_price` double(10, 2) NULL DEFAULT NULL COMMENT '一天的价格',
  `hour_price` double(10, 2) NULL DEFAULT NULL COMMENT '钟点房的价格',
  `room_type_del` int(255) NULL DEFAULT 0 COMMENT '是否删除，默认为0，0为没有删除',
  PRIMARY KEY (`room_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for system_info
-- ----------------------------
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info`  (
  `id` int(1) NOT NULL,
  `hotel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '酒店名称',
  `system_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `welcome_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统欢迎词',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，可以自增长',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_status` int(1) NULL DEFAULT 0 COMMENT '状态，默认为0，0为正常',
  `user_del` int(1) NULL DEFAULT 0 COMMENT '是否删除，默认为0，0为没有删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
  `vip_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'vipID',
  `guest_id` int(11) NULL DEFAULT NULL COMMENT '顾客ID',
  `vip_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'vip卡号',
  `vip_integral` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '积分',
  `vip_del` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`vip_id`) USING BTREE,
  INDEX `guest_id`(`guest_id`) USING BTREE,
  CONSTRAINT `vip_ibfk_1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
