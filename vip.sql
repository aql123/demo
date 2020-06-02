/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : vip

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-06-02 18:19:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '张三', '123456');
INSERT INTO `admin` VALUES ('2', '李四', '123456');
INSERT INTO `admin` VALUES ('3', 'admin', '123');

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `money` varchar(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `userId` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of consumption
-- ----------------------------
INSERT INTO `consumption` VALUES ('2', '张飒', '2', null, null, '1001');
INSERT INTO `consumption` VALUES ('3', '李峰', '2', null, null, '1002');
INSERT INTO `consumption` VALUES ('4', '李峰', '2', null, null, '1002');
INSERT INTO `consumption` VALUES ('5', '李峰', '11', null, null, '1002');
INSERT INTO `consumption` VALUES ('6', '王伟', '33', null, null, '1004');
INSERT INTO `consumption` VALUES ('7', '张三', '33', null, null, '1003');
INSERT INTO `consumption` VALUES ('8', '张三', '33', null, null, '1003');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `money` int(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `userId` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES ('11', '张飒', '2', null, null, '1001');
INSERT INTO `recharge` VALUES ('12', '李峰', '2', null, null, '1002');
INSERT INTO `recharge` VALUES ('13', '张三', '2', null, null, '1003');
INSERT INTO `recharge` VALUES ('14', '王伟', '2', null, null, '1004');
INSERT INTO `recharge` VALUES ('15', '张飒', '22', null, null, '1001');
INSERT INTO `recharge` VALUES ('16', '张飒', '11', null, null, '1001');

-- ----------------------------
-- Table structure for vipcard
-- ----------------------------
DROP TABLE IF EXISTS `vipcard`;
CREATE TABLE `vipcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `status` varchar(4) CHARACTER SET utf8mb4 DEFAULT NULL,
  `integral` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipcard
-- ----------------------------
INSERT INTO `vipcard` VALUES ('1001', '张飒', '123', '正常', '106');
INSERT INTO `vipcard` VALUES ('1002', '李峰', '116', '正常', '49');
INSERT INTO `vipcard` VALUES ('1003', '张三', '1442', '正常', '46');
INSERT INTO `vipcard` VALUES ('1004', '王伟', '128', '正常', '64');
INSERT INTO `vipcard` VALUES ('1005', '猪', '78', '挂失', '90');
INSERT INTO `vipcard` VALUES ('1006', '1', '2', '挂失', '3');

-- ----------------------------
-- Table structure for vipusers
-- ----------------------------
DROP TABLE IF EXISTS `vipusers`;
CREATE TABLE `vipusers` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `tip` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipusers
-- ----------------------------
INSERT INTO `vipusers` VALUES ('1', '张飒', '1001', '2020-06-10', '17862883351', '是');
INSERT INTO `vipusers` VALUES ('2', '李峰', '1002', '2020-06-09', '15684136743', '是');
INSERT INTO `vipusers` VALUES ('3', '张三', '1003', '1999-06-08', '19278654387', '否');
INSERT INTO `vipusers` VALUES ('4', '王伟', '1004', '2020-06-07', '17866543210', '是');
INSERT INTO `vipusers` VALUES ('5', '猪', '1005', '2020-06-06', '18976543289', '否');
INSERT INTO `vipusers` VALUES ('8', '加内特', '1009', '2020-06-05', '17897654321', '是');
INSERT INTO `vipusers` VALUES ('10', '伦纳德', '1231', '2020-06-03', '888888888', '否');
INSERT INTO `vipusers` VALUES ('11', '乔丹', '1211', '2020-06-04', '33', '是');
