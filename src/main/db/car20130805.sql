/*
Navicat MySQL Data Transfer

Source Server         : car
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2013-08-05 07:34:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a
-- ----------------------------
DROP TABLE IF EXISTS `a`;
CREATE TABLE `a` (
  `a` varchar(255) NOT NULL,
  PRIMARY KEY (`a`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carCard` varchar(10) NOT NULL,
  `carOwnerId` int(11) DEFAULT NULL,
  `carOwnerName` varchar(255) DEFAULT NULL COMMENT '冗余设计，查找方便',
  `carType` varchar(10) DEFAULT NULL,
  `InputTime` datetime DEFAULT NULL,
  PRIMARY KEY (`carCard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for carowner
-- ----------------------------
DROP TABLE IF EXISTS `carowner`;
CREATE TABLE `carowner` (
  `carOwnerId` int(11) NOT NULL AUTO_INCREMENT,
  `carOwnerName` varchar(255) DEFAULT NULL,
  `carOwnerPhone` varchar(255) DEFAULT NULL,
  `carOwnerAddress` varchar(255) DEFAULT NULL,
  `inputTime` datetime DEFAULT NULL,
  PRIMARY KEY (`carOwnerId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for maintance
-- ----------------------------
DROP TABLE IF EXISTS `maintance`;
CREATE TABLE `maintance` (
  `maintanceId` varchar(14) NOT NULL,
  `carCard` varchar(10) DEFAULT NULL,
  `carOwnerId` varchar(10) DEFAULT NULL,
  `carStatus` int(11) DEFAULT NULL,
  `failReason` varchar(255) DEFAULT NULL,
  `failType` int(11) DEFAULT NULL COMMENT '1保养，2 维修',
  `finishedTime` datetime DEFAULT NULL,
  `maintanceEvaluate` int(11) DEFAULT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `repaireTime` datetime DEFAULT NULL,
  `takenTime` datetime DEFAULT NULL,
  PRIMARY KEY (`maintanceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
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
-- Table structure for orderdetail
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
