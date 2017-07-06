/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : ojdb

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-07-06 09:30:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `pro_id` int(11) NOT NULL,
  `pro_title` varchar(50) NOT NULL,
  `pro_description` text,
  `usecase_in` text,
  `usecase_out` text,
  `pro_maker` varchar(50) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_num` int(11) NOT NULL,
  `solver` varchar(50) NOT NULL,
  `problem_id` int(11) NOT NULL,
  `record_time` datetime DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
