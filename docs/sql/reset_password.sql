/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-13 10:10:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reset_password
-- ----------------------------
DROP TABLE IF EXISTS `reset_password`;
CREATE TABLE `reset_password` (
  `id` int(11) NOT NULL COMMENT '用户ID',
  `token` char(40) NOT NULL COMMENT 'token',
  `lapse_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '失效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reset_password
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
