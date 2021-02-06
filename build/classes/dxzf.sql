/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : dxzf

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-01-18 17:31:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_combo
-- ----------------------------
DROP TABLE IF EXISTS `tb_combo`;
CREATE TABLE `tb_combo` (
  `COMBO_id` int NOT NULL AUTO_INCREMENT COMMENT '套餐id',
  `COMBO_name` varchar(20) NOT NULL COMMENT '套餐名',
  `COMBO_price` double DEFAULT '0' COMMENT '套餐价格',
  `COMBO_des` varchar(50) DEFAULT NULL COMMENT '套餐介绍',
  `COMBO_img` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`COMBO_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_combo
-- ----------------------------
INSERT INTO `tb_combo` VALUES ('1', '套餐1', '88.8', '这是一个套餐描述', 'taocan1.jpg');
INSERT INTO `tb_combo` VALUES ('2', '套餐2', '66.6', '这是一个套餐描述', 'taocan2.jpg');
INSERT INTO `tb_combo` VALUES ('3', '套餐3', '22', '这是一个套餐描述', 'taocan3.jpg');

-- ----------------------------
-- Table structure for tb_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `USER_id` int NOT NULL COMMENT '用户名',
  `USER_phone` char(11) NOT NULL COMMENT '用户电话',
  `USER_money` double DEFAULT '0' COMMENT '账户余额',
  `USER_combo` int DEFAULT NULL COMMENT '用户当前套餐',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_info
-- ----------------------------
INSERT INTO `tb_info` VALUES ('1', '1', '18851730833', '99.9', '3');


-- ----------------------------
-- Table structure for tb_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `USER_phone` char(11) NOT NULL COMMENT '用户电话',
  `Consume_money` double DEFAULT '0' COMMENT '消费金额',
  `Consume_time` date DEFAULT NULL COMMENT '消费时间',
  `Consume_note` varchar(50) DEFAULT NULL COMMENT '消费说明',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_record
-- ----------------------------
INSERT INTO `tb_record` VALUES ('1', '18851730833', '78', '2020-12-12', '充值');
INSERT INTO `tb_record` VALUES ('2', '18851730833', '-24', '2020-12-13', '消费');

-- ----------------------------
-- Table structure for tb_userdata
-- ----------------------------
DROP TABLE IF EXISTS `tb_userdata`;
CREATE TABLE `tb_userdata` (
  `USER_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `USER_name` varchar(20) NOT NULL COMMENT '用户名',
  `USER_phone` varchar(11) NOT NULL COMMENT '电话',
  `USER_password` varchar(20) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`USER_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userdata
-- ----------------------------
INSERT INTO `tb_userdata` VALUES ('1', 'test', '18851730833', '654321');

