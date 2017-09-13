/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-13 10:09:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote_record
-- ----------------------------
DROP TABLE IF EXISTS `vote_record`;
CREATE TABLE `vote_record` (
  `id` int(11) NOT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `device_mac` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `QQ` varchar(255) DEFAULT NULL,
  `WX` varchar(255) DEFAULT NULL,
  `voter_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_record
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
