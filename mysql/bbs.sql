/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50628
Source Host           : 127.0.0.1:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-10-26 10:53:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fatie
-- ----------------------------
DROP TABLE IF EXISTS `fatie`;
CREATE TABLE `fatie` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `titles` varchar(100) NOT NULL,
  `fcontent` varchar(2000) NOT NULL,
  `userid` int(11) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='发帖表';

-- ----------------------------
-- Records of fatie
-- ----------------------------
INSERT INTO `fatie` VALUES ('4', '我是陈意涵', '大家好，我爱你们。', '6', '2018_10_26_10_51_57_id6_2017_9_1_16_57_31_id7_814f253234a906a1d422f3c4fe832fa1.jpg', '2018-10-26 10:51:57', '陈意涵');

-- ----------------------------
-- Table structure for pinglun
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pcontent` varchar(400) NOT NULL,
  `userid` int(11) NOT NULL,
  `byid` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pinglun
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `family` varchar(45) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', '陈意涵', '123456', '924818949@qq.com', '成都', '长得漂亮。', '2017-12-18 19:44:57');

-- ----------------------------
-- Table structure for via
-- ----------------------------
DROP TABLE IF EXISTS `via`;
CREATE TABLE `via` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `photo` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of via
-- ----------------------------
INSERT INTO `via` VALUES ('6', '2018_10_26_10_51_35_id6_156e36861bcbe7ccd83b9bada2e99322.jpg');
