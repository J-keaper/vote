/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-13 10:09:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote_option
-- ----------------------------
DROP TABLE IF EXISTS `vote_option`;
CREATE TABLE `vote_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `external_link` varchar(255) DEFAULT NULL,
  `detail_url` varchar(255) DEFAULT NULL,
  `rank_position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_option
-- ----------------------------
INSERT INTO `vote_option` VALUES ('1', '1', null, null, '', 'www.baidu.com', null, '1');
INSERT INTO `vote_option` VALUES ('2', '6', null, '', '', '', '', '0');
INSERT INTO `vote_option` VALUES ('3', '6', null, '', '', '', '', '1');
SET FOREIGN_KEY_CHECKS=1;
