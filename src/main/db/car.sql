/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2013-05-20 21:59:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `BuyId` int(11) NOT NULL,
  `InputDate` datetime DEFAULT NULL,
  `BuyDate` datetime DEFAULT NULL,
  `InputPersonId` varchar(255) DEFAULT NULL,
  `BuyPerson` varchar(255) DEFAULT NULL,
  `Discount` decimal(10,0) DEFAULT NULL,
  `TotalPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`BuyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `BuyId` int(11) NOT NULL,
  `PeiJianId` int(11) NOT NULL,
  `BarCode` varchar(255) DEFAULT NULL,
  `PeiJianFactory` varchar(255) DEFAULT NULL,
  `PeiJianPrice` decimal(10,0) DEFAULT NULL,
  `PeiJianNum` int(11) DEFAULT NULL,
  `PeiJianDiscount` decimal(10,0) DEFAULT NULL,
  `PeiJianTotalPrice` decimal(10,0) DEFAULT NULL,
  `PeiJianSingleDiscount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`PeiJianId`,`BuyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
