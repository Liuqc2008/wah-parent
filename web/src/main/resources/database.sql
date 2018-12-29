/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : how2java

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-12-29 11:15:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('84', 'xin', 'asdfghjkll', '2018-09-15 10:51:06');
INSERT INTO `account` VALUES ('85', 'xx', '1234', '2018-09-16 11:20:19');
INSERT INTO `account` VALUES ('86', 'abc', '123456', '2018-09-17 11:21:27');
INSERT INTO `account` VALUES ('87', 'text', 'text1', '2018-09-25 17:53:06');
INSERT INTO `account` VALUES ('88', 's1', '1223131', '2018-09-25 17:57:36');
INSERT INTO `account` VALUES ('89', '用', '1', '2018-09-25 17:57:52');
INSERT INTO `account` VALUES ('90', 's', 'xxx', '2018-09-26 09:04:56');
INSERT INTO `account` VALUES ('91', '', '', '2018-09-26 09:06:41');
INSERT INTO `account` VALUES ('92', '', '', '2018-09-26 09:07:56');
INSERT INTO `account` VALUES ('93', '用户名：', '密码：密码：密码：', '2018-09-26 09:10:47');
INSERT INTO `account` VALUES ('94', '', '', '2018-09-26 09:10:56');
INSERT INTO `account` VALUES ('97', 'x', 'fas', '2018-09-26 10:01:01');
INSERT INTO `account` VALUES ('98', '用户', '45645', '2018-09-26 11:14:09');
INSERT INTO `account` VALUES ('99', 'Transaction', '', '2018-10-12 11:05:16');
INSERT INTO `account` VALUES ('100', 'Transaction', '', '2018-10-12 11:06:03');
INSERT INTO `account` VALUES ('104', '用户名用户名', '密码密码', '2018-10-12 14:53:28');
INSERT INTO `account` VALUES ('105', '用户名：', '密码', '2018-10-12 14:53:43');
INSERT INTO `account` VALUES ('106', '用户名', '用户名', '2018-10-12 14:56:21');
INSERT INTO `account` VALUES ('107', '用户名：', '码1', '2018-10-12 14:58:53');

-- ----------------------------
-- Table structure for `accountrole`
-- ----------------------------
DROP TABLE IF EXISTS `accountrole`;
CREATE TABLE `accountrole` (
  `accountid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`accountid`,`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accountrole
-- ----------------------------
INSERT INTO `accountrole` VALUES ('84', '85');
INSERT INTO `accountrole` VALUES ('85', '86');
INSERT INTO `accountrole` VALUES ('87', '85');
INSERT INTO `accountrole` VALUES ('88', '85');
INSERT INTO `accountrole` VALUES ('89', '85');
INSERT INTO `accountrole` VALUES ('90', '85');
INSERT INTO `accountrole` VALUES ('91', '85');
INSERT INTO `accountrole` VALUES ('92', '85');
INSERT INTO `accountrole` VALUES ('93', '85');
INSERT INTO `accountrole` VALUES ('94', '85');
INSERT INTO `accountrole` VALUES ('95', '85');
INSERT INTO `accountrole` VALUES ('96', '85');
INSERT INTO `accountrole` VALUES ('97', '85');
INSERT INTO `accountrole` VALUES ('98', '85');
INSERT INTO `accountrole` VALUES ('99', '85');
INSERT INTO `accountrole` VALUES ('100', '85');
INSERT INTO `accountrole` VALUES ('101', '85');

-- ----------------------------
-- Table structure for `category_`
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES ('1', 'category1');
INSERT INTO `category_` VALUES ('2', 'category2');
INSERT INTO `category_` VALUES ('3', 'category3');
INSERT INTO `category_` VALUES ('4', 'category4');
INSERT INTO `category_` VALUES ('5', 'category5');
INSERT INTO `category_` VALUES ('6', 'new Category');
INSERT INTO `category_` VALUES ('7', 'new Category');
INSERT INTO `category_` VALUES ('8', 'new Category');
INSERT INTO `category_` VALUES ('9', 'new Category');
INSERT INTO `category_` VALUES ('10', 'new Category');
INSERT INTO `category_` VALUES ('11', 'new Category');
INSERT INTO `category_` VALUES ('12', 'new Category');
INSERT INTO `category_` VALUES ('13', 'new Category');
INSERT INTO `category_` VALUES ('14', 'new Category');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderno` varchar(255) NOT NULL DEFAULT '',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `desc` varchar(255) NOT NULL DEFAULT '',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('85', '超级管理员', '', '2018-09-26 16:55:14');
INSERT INTO `role` VALUES ('86', '管理员', '', '2018-09-26 16:56:55');

-- ----------------------------
-- Table structure for `systemlog`
-- ----------------------------
DROP TABLE IF EXISTS `systemlog`;
CREATE TABLE `systemlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `detail` text,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemlog
-- ----------------------------
INSERT INTO `systemlog` VALUES ('1', 'name', 'AlertException', '2018-10-12 16:22:41');
INSERT INTO `systemlog` VALUES ('2', 'System', '系统错误{/ by zero}', '2018-10-12 16:26:33');
INSERT INTO `systemlog` VALUES ('3', 'System', '系统错误：/ by zero', '2018-10-12 16:28:23');
INSERT INTO `systemlog` VALUES ('4', 'Alert', 'AlertException', '2018-10-12 16:28:37');
INSERT INTO `systemlog` VALUES ('5', 'System', '系统错误：\r\n### Error updating database.  Cause: com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column \'name\' at row 1\r\n### The error may involve com.how2java.mapper.AccountMapper.add-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into account(name, password, createDate)      values(?, ?, ?)\r\n### Cause: com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column \'name\' at row 1\n; SQL []; Data truncation: Data too long for column \'name\' at row 1; nested exception is com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column \'name\' at row 1', '2018-10-12 16:49:42');

