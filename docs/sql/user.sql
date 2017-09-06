CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nick_name` varchar(30) NOT NULL COMMENT '昵称',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `register_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `activate_status` tinyint(4) NOT NULL,
  `activate_code` char(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Keaper', '1273570695@qq.com', '18434361009', '123456', '2017-09-03 19:30:56', '0', '');
INSERT INTO `user` VALUES ('3', 'Edward', '1042137827@qq.com', '18434361008', '123456', '2017-09-03 19:31:11', '0', '');
INSERT INTO `user` VALUES ('4', '哈哈', '18434361009@163.com', '18434361008', '123456', '2017-08-31 15:31:07', '0', 'fc4c60e2658d4ddd86e31ecfd590f4b6');
INSERT INTO `user` VALUES ('6', 'Time', '1273570694@qq.com', '18434361007', '123456', '2017-08-31 15:36:31', '0', '145e7f7a8ca44292a25d3ab43065f868');
INSERT INTO `user` VALUES ('7', 'Gentle', 'gentlemenlovelt@gmail.com', '15536907611', '123457', '2017-09-06 11:07:09', '1', 'dsadsaddddddddddddddddddddddaa');