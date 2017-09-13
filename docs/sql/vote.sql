/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-13 10:09:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `creator_id` int(11) NOT NULL COMMENT '创建者ID',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `description` text COMMENT '描述信息',
  `text_after_vote` text COMMENT '投票完成后显示信息',
  `access_count` bigint(20) DEFAULT '0' COMMENT '访问量',
  `choice_min` tinyint(4) DEFAULT '1' COMMENT '最小选择项数',
  `choice_max` tinyint(4) DEFAULT '1' COMMENT '最大选择项数',
  `count_per_row` tinyint(4) DEFAULT NULL,
  `pagination_count` int(11) DEFAULT NULL COMMENT '分页数量',
  `voter_info_collect` tinyint(4) DEFAULT NULL COMMENT '投票者信息收集',
  `start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `IP_validate_rule` int(11) DEFAULT NULL COMMENT 'IP验证规则',
  `device_validate_rule` int(11) DEFAULT NULL COMMENT '设备验证规则',
  `email_validate_rule` int(11) DEFAULT NULL COMMENT '邮箱验证规则',
  `phone_validate_rule` int(11) DEFAULT NULL COMMENT '收集验证规则',
  `QQ_validate_rule` int(11) DEFAULT NULL COMMENT 'QQ验证规则',
  `WX_validate_rule` int(11) DEFAULT NULL COMMENT '微信验证规则',
  `vote_password` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '1', '选举', null, null, '0', '0', '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', null, '2017-09-13 02:46:11');
INSERT INTO `vote` VALUES ('2', '1', '选举', null, null, '0', '0', '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', null, '2017-09-13 02:47:01');
INSERT INTO `vote` VALUES ('3', '1', '选举', null, null, '0', '0', '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', null, '2017-09-13 02:50:14');
INSERT INTO `vote` VALUES ('4', '1', '选举', null, null, '0', '0', '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', null, '2017-09-13 02:53:22');
INSERT INTO `vote` VALUES ('5', '1', '选举', null, null, '0', '0', '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', null, '2017-09-13 03:18:55');
INSERT INTO `vote` VALUES ('6', '1', 'gfdb', '', '', '0', '1', '1', '1', '0', '0', '2017-09-19 00:00:00', null, '0', '0', '0', '0', '0', '0', 'gfdg', '2017-09-13 03:45:41');
SET FOREIGN_KEY_CHECKS=1;
