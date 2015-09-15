/*
Navicat MySQL Data Transfer

Source Server         : yxz
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2013-05-25 18:11:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `BuyId` bigint(20) NOT NULL,
  `BuyDate` datetime DEFAULT NULL,
  `BuyPerson` varchar(255) DEFAULT NULL,
  `Discount` bigint(20) DEFAULT NULL,
  `InputDate` datetime DEFAULT NULL,
  `InputPersonId` varchar(255) DEFAULT NULL,
  `TotalPrice` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`BuyId`),
  UNIQUE KEY `BuyId` (`BuyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('17022148160311', '2013-05-25 15:15:03', '3', '3', null, null, null);
INSERT INTO `order` VALUES ('17953124984256', '2013-05-25 15:30:34', '3', '3', null, null, null);
INSERT INTO `order` VALUES ('18019648540188', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('20245124980524', '2013-05-25 16:08:46', '333', '333', null, null, null);
INSERT INTO `order` VALUES ('20990714028257', '2013-05-25 16:21:12', '3', '3', '2013-05-25 16:21:12', '3', '2');
INSERT INTO `order` VALUES ('22983998668021', '2013-05-25 16:54:25', 'yxz', '4', '2013-05-25 16:54:25', '3', '5');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `BuyId` int(11) NOT NULL,
  `PeiJianId` int(11) NOT NULL,
  `BarCode` varchar(255) DEFAULT NULL,
  `PeiJianDiscount` bigint(20) DEFAULT NULL,
  `PeiJianFactory` varchar(255) DEFAULT NULL,
  `PeiJianNum` int(11) DEFAULT NULL,
  `PeiJianPrice` bigint(20) DEFAULT NULL,
  `PeiJianSingleDiscount` bigint(20) DEFAULT NULL,
  `PeiJianTotalPrice` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`BuyId`,`PeiJianId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
