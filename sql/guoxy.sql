/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : guoxy

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-20 15:13:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(8) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `adminPwd` varchar(20) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `bigtype`
-- ----------------------------
DROP TABLE IF EXISTS `bigtype`;
CREATE TABLE `bigtype` (
  `btId` int(8) NOT NULL AUTO_INCREMENT,
  `btName` varchar(10) NOT NULL,
  PRIMARY KEY (`btId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bigtype
-- ----------------------------
INSERT INTO `bigtype` VALUES ('0', '男装');
INSERT INTO `bigtype` VALUES ('1', '女装');
INSERT INTO `bigtype` VALUES ('2', '男鞋');
INSERT INTO `bigtype` VALUES ('3', '女鞋');
INSERT INTO `bigtype` VALUES ('4', '袜品');
INSERT INTO `bigtype` VALUES ('5', '家居');
INSERT INTO `bigtype` VALUES ('6', '童装');
INSERT INTO `bigtype` VALUES ('7', '内衣');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(8) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) DEFAULT NULL,
  `goodsShow` varchar(100) DEFAULT NULL,
  `goodsPrice` int(8) DEFAULT NULL,
  `goodsCount` int(8) DEFAULT NULL,
  `season` int(8) DEFAULT NULL,
  `btId` int(8) DEFAULT NULL,
  `stId` int(8) DEFAULT NULL,
  `smallImg` varchar(100) DEFAULT NULL,
  `bigImg` varchar(100) DEFAULT NULL,
  `clickNum` int(8) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '女士T恤', '蝙蝠衣 黑色 女款', '95', '505', '2', '1', '21', 'a9a37c43b9c14de18c0a37f61a034f9b.png', '0c8fe9228c84465bb9a307bd1ec97371.png', '0', '2017-10-14');
INSERT INTO `goods` VALUES ('4', '女士T恤', '纯色 黑色 女款', '45', '630', '2', '1', '21', 'ae2fc21644a24a5d9c3bd7266de64e63.png', 'f38ecab28b844aafb758f80a22a9355a.png', '0', '2017-10-14');
INSERT INTO `goods` VALUES ('8', '女士T恤', '女款 灰色 图案', '65', '630', '2', '1', '21', '25d95debbb474fdca4382f9e03aa902a.png', '4dfbef237e734b03802d3cb774c5df82.png', '0', '2017-10-14');
INSERT INTO `goods` VALUES ('9', '女士T恤', '可爱 白色 女款', '123', '360', '2', '1', '21', '1cd6183d2c664e36adfc2a2c58f1558f.png', '96cfaaac903147679de989d76710c188.png', '0', '2017-10-14');
INSERT INTO `goods` VALUES ('13', '男士T恤', '瞅你咋地', '98', '632', '2', '0', '11', 'd4b83c6dddca466eaaef01e34493cbe5.png', '85ccb739d6a3498f97591466b2a9cad5.png', '0', '2017-10-13');
INSERT INTO `goods` VALUES ('16', '男士T恤', '纯色 男款 白色', '68', '450', '2', '0', '11', 'b4c7a8f4d9a148c39aad0f38447abd23.png', '4495cb22a5ff41d28ba59b74d72e2e08.png', '0', '2017-10-15');
INSERT INTO `goods` VALUES ('19', '男士衬衫', '熊本熊 黑色 男款', '59', '602', '2', '0', '11', 'fc687f7d2d3442a3af049860f6db700b.png', 'b6a7d1419b2a403fbf22514c26c90dfd.png', '0', '2017-10-15');
INSERT INTO `goods` VALUES ('20', '男士T恤', '纯色 圆领 黑色 男士', '89', '320', '2', '0', '11', '82b9e6626f4d4438b844848af11bac5e.png', '65b5dd1c269041b1ae644fa95ad16eca.png', '3', '2017-10-12');
INSERT INTO `goods` VALUES ('21', '凡客针织', '清凉 空调衣 黄色', '89', '600', '3', '1', '19', '147fe66ef66747f0bbdca00f80c0a97d.png', '65c2226392e948809b46a60f6304d004.png', '16', '2017-10-14');
INSERT INTO `goods` VALUES ('22', '凡客针织', '女款 红色 圆领', '123', '345', '3', '1', '19', 'ee932587da8c4c00abbb7c4018875e9f.png', 'b12d6f3553be4480886973d1ba8e092b.png', '39', '2017-10-13');
INSERT INTO `goods` VALUES ('23', '凡客针织', '黑色 圆领 女款', '96', '557', '3', '1', '19', 'c4353fd9d0b84333a37a79b5050c833b.png', '2bcaacb5fe9f48008292f7fb50b7230f.png', '23', '2017-10-15');
INSERT INTO `goods` VALUES ('24', '凡客针织', '女装 圆领 条纹', '123', '600', '2', '1', '19', '9c69ffb435664e66b0d543c944262840.png', '8c3c47b7ee324895ae8edfada41a4302.png', '0', '2017-10-15');
INSERT INTO `goods` VALUES ('25', '凡客针织', '男士 灰色 针织开衫', '123', '321', '3', '0', '2', '396f10653b3c4fb0805ab530791d1a85.png', '488d7d11e4a34c8dab2f783440964945.png', '64', '2017-10-15');
INSERT INTO `goods` VALUES ('26', '凡客针织', '男士 黑白灰 尖领', '69', '545', '3', '0', '2', '806597dce2c343d6a4986369fd593ea7.png', '61a675f2c7ff4928b7037a85a107dca2.png', '17', '2017-10-15');
INSERT INTO `goods` VALUES ('27', '凡客针织', '男士 圆领', '96', '652', '3', '0', '2', 'f639fd90757c4ba6a5f7cdb93e246165.png', '36ffeb218e1f4fc0864752aa578191bf.png', '0', '2017-10-15');
INSERT INTO `goods` VALUES ('28', '男士针织', '黑色 开衫', '89', '360', '3', '0', '2', '7a01b582e3894cc58ba26a961d9dcc83.png', '541a385858a848a98b8aadb61fe7a640.png', '16', '2017-10-15');
INSERT INTO `goods` VALUES ('29', '凡客衬衫', '水柔棉 短袖 男款 古蓝色', '98', '600', '3', '0', '7', '011ff182bb344b01b3a219707e538a8c.png', '3371ae7768a5442a87a6afddb1ec692e.png', '0', '2017-10-18');
INSERT INTO `goods` VALUES ('30', '凡客休闲裤', '轻弹水洗 收口慢跑裤 男款 黑色', '96', '360', '2', '0', '14', '50973c1264f2487fa689a53d22535dde.png', '51bc8a4a3dc141e08ec849a9a6605e52.png', '0', '2017-10-18');
INSERT INTO `goods` VALUES ('31', '凡客哑光收腹提臀微压连裤袜', '140D 经典款 黑色 ', '48', '490', '3', '4', '37', '17ea1879638d43b78008d549e013a2a0.png', '288ee5d5b66c4e18a56cab067b8f6201.png', '103', '2017-10-18');
INSERT INTO `goods` VALUES ('32', '男士衬衫', '蓝色 衬衫 蓝色', '96', '358', '3', '0', '8', 'b92cde55fcf145b5bd96f7e45a5a6d4f.jpg', '93d4902386cf44d385ca318e5c15005b.jpg', '5', '2017-10-18');
INSERT INTO `goods` VALUES ('33', '凡客衬衫', '衬衫 男 红黑格', '98', '628', '3', '0', '7', '80f435ce45ba4553a2bb42648f754470.jpg', 'b31bcfa3177f4227a38720c0ae606833.jpg', '2', '2017-10-18');
INSERT INTO `goods` VALUES ('34', '凡客衬衫', '男 衬衫 亚麻', '89', '342', '3', '0', '7', '0bfa24069f724d2899f14471095cafe6.jpg', '4e2edc4d5f3b4c8e90e5c60273a3ecea.jpg', '4', '2017-10-18');
INSERT INTO `goods` VALUES ('35', '凡客衬衫', '男 格子衬衫 ', '98', '360', '3', '0', '7', '8c1e34b438f54251994cae306aa7069a.jpg', 'ecf9f11393d3492ca69c8f8a82cc7406.jpg', '0', '2017-10-20');

-- ----------------------------
-- Table structure for `gwc`
-- ----------------------------
DROP TABLE IF EXISTS `gwc`;
CREATE TABLE `gwc` (
  `gwcId` int(8) NOT NULL AUTO_INCREMENT,
  `goodsId` int(8) NOT NULL,
  `userId` int(8) NOT NULL,
  `count` int(8) NOT NULL,
  PRIMARY KEY (`gwcId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gwc
-- ----------------------------
INSERT INTO `gwc` VALUES ('2', '25', '1', '1');
INSERT INTO `gwc` VALUES ('3', '22', '1', '1');
INSERT INTO `gwc` VALUES ('8', '32', '0', '1');
INSERT INTO `gwc` VALUES ('9', '32', '0', '1');
INSERT INTO `gwc` VALUES ('10', '32', '0', '1');

-- ----------------------------
-- Table structure for `orderform`
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `orderId` int(8) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(30) DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  `goodsId` int(8) DEFAULT NULL,
  `status` int(8) DEFAULT NULL,
  `count` int(8) DEFAULT NULL,
  `CreateTime` date DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('22', '201710171728400000000173', '1', '21', '3', '1', '2017-10-17');
INSERT INTO `orderform` VALUES ('23', '201710171728410000000177', '1', '21', '3', '1', '2017-10-17');
INSERT INTO `orderform` VALUES ('26', '201710171917230000000160', '1', '28', '3', '1', '2017-10-17');
INSERT INTO `orderform` VALUES ('27', '201710171917300000000160', '1', '25', '1', '1', '2017-10-17');
INSERT INTO `orderform` VALUES ('28', '201710171917370000000106', '1', '25', '3', '1', '2017-10-17');
INSERT INTO `orderform` VALUES ('29', '201710171931250000000100', '1', '22', '3', '3', '2017-10-17');
INSERT INTO `orderform` VALUES ('30', '201710171931490000000121', '1', '22', '3', '3', '2017-10-17');
INSERT INTO `orderform` VALUES ('31', '201710171932280000000157', '1', '22', '3', '9', '2017-10-17');
INSERT INTO `orderform` VALUES ('32', '201710172335110000000185', '1', '22', '1', '3', '2017-10-17');
INSERT INTO `orderform` VALUES ('33', '201710172339220000000179', '1', '26', '1', '9', '2017-10-17');
INSERT INTO `orderform` VALUES ('34', '201710180006220000000106', '1', '22', '3', '1', '2017-10-18');
INSERT INTO `orderform` VALUES ('35', '201710180028010000000170', '1', '23', '1', '5', '2017-10-18');
INSERT INTO `orderform` VALUES ('36', '201710180029540000000131', '1', '23', '3', '1', '2017-10-18');
INSERT INTO `orderform` VALUES ('37', '201710181757300000000146', '1', '22', '0', '1', '2017-10-18');
INSERT INTO `orderform` VALUES ('38', '201710181759470000000135', '1', '20', '1', '10', '2017-10-18');
INSERT INTO `orderform` VALUES ('39', '201710181808110000000115', '1', '20', '3', '10', '2017-10-18');
INSERT INTO `orderform` VALUES ('40', '201710191750210000000005', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('41', '201710191750220000000025', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('42', '201710191750220000000039', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('43', '201710191750220000000028', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('44', '201710191750220000000035', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('45', '201710191750290000000090', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('46', '201710191750290000000056', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('47', '201710191750330000000055', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('48', '201710191750330000000016', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('49', '201710191750330000000022', '0', '26', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('50', '201710191751300000000097', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('51', '201710191811470000000043', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('52', '201710191811490000000016', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('53', '201710191811490000000071', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('54', '201710191811490000000029', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('55', '201710191811500000000056', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('56', '201710191811500000000016', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('57', '201710191811500000000082', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('58', '201710191811500000000023', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('59', '201710191811500000000011', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('60', '201710191811510000000047', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('61', '201710191811510000000084', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('62', '201710191811510000000096', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('63', '201710191811510000000020', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('64', '201710191811510000000028', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('65', '201710191811520000000074', '0', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('66', '201710191816010000000046', '18', '32', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('67', '201710191820230000000014', '19', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('68', '201710191820260000000072', '19', '34', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('69', '201710191822090000000046', '20', '32', '3', '1', '2017-10-19');
INSERT INTO `orderform` VALUES ('70', '201710201445110000000093', '22', '33', '3', '1', '2017-10-20');
INSERT INTO `orderform` VALUES ('71', '201710201445250000000019', '22', '31', '1', '10', '2017-10-20');
INSERT INTO `orderform` VALUES ('72', '201710201445260000000035', '22', '33', '0', '1', '2017-10-20');

-- ----------------------------
-- Table structure for `smalltype`
-- ----------------------------
DROP TABLE IF EXISTS `smalltype`;
CREATE TABLE `smalltype` (
  `stId` int(8) NOT NULL AUTO_INCREMENT,
  `stName` varchar(18) DEFAULT NULL,
  `btId` int(8) DEFAULT NULL,
  PRIMARY KEY (`stId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smalltype
-- ----------------------------
INSERT INTO `smalltype` VALUES ('1', '卫衣', '0');
INSERT INTO `smalltype` VALUES ('2', '针织衫', '0');
INSERT INTO `smalltype` VALUES ('3', '外套', '0');
INSERT INTO `smalltype` VALUES ('4', '西服', '0');
INSERT INTO `smalltype` VALUES ('5', '大衣', '0');
INSERT INTO `smalltype` VALUES ('6', '免烫衬衫', '0');
INSERT INTO `smalltype` VALUES ('7', '休闲衬衫', '0');
INSERT INTO `smalltype` VALUES ('8', '麻衬衫', '0');
INSERT INTO `smalltype` VALUES ('9', '水柔绵', '0');
INSERT INTO `smalltype` VALUES ('10', '皮肤衣', '0');
INSERT INTO `smalltype` VALUES ('11', 'T恤', '0');
INSERT INTO `smalltype` VALUES ('12', '短袖衬衫', '0');
INSERT INTO `smalltype` VALUES ('13', 'POLO衫', '0');
INSERT INTO `smalltype` VALUES ('14', '休闲裤', '0');
INSERT INTO `smalltype` VALUES ('15', '牛仔裤', '0');
INSERT INTO `smalltype` VALUES ('16', '针织裤', '0');
INSERT INTO `smalltype` VALUES ('17', '外套', '1');
INSERT INTO `smalltype` VALUES ('18', '卫衣', '1');
INSERT INTO `smalltype` VALUES ('19', '针织衫', '1');
INSERT INTO `smalltype` VALUES ('20', '休闲衬衫', '1');
INSERT INTO `smalltype` VALUES ('21', 'T恤', '1');
INSERT INTO `smalltype` VALUES ('22', '水柔绵', '1');
INSERT INTO `smalltype` VALUES ('23', '皮肤衣', '1');
INSERT INTO `smalltype` VALUES ('24', '运动速干', '1');
INSERT INTO `smalltype` VALUES ('25', '麻衬衫裙', '1');
INSERT INTO `smalltype` VALUES ('26', '牛仔裤', '1');
INSERT INTO `smalltype` VALUES ('27', '针织裤', '1');
INSERT INTO `smalltype` VALUES ('28', '休闲裤', '1');
INSERT INTO `smalltype` VALUES ('29', '复古跑', '2');
INSERT INTO `smalltype` VALUES ('30', '帆布鞋', '2');
INSERT INTO `smalltype` VALUES ('31', '休闲鞋', '2');
INSERT INTO `smalltype` VALUES ('32', '皮鞋', '2');
INSERT INTO `smalltype` VALUES ('33', '复古跑', '3');
INSERT INTO `smalltype` VALUES ('34', '帆布鞋', '3');
INSERT INTO `smalltype` VALUES ('35', '休闲鞋', '3');
INSERT INTO `smalltype` VALUES ('36', '连裤袜', '4');
INSERT INTO `smalltype` VALUES ('37', '打底裤', '4');
INSERT INTO `smalltype` VALUES ('38', '棉袜', '4');
INSERT INTO `smalltype` VALUES ('39', '床品套件', '5');
INSERT INTO `smalltype` VALUES ('40', '被子', '5');
INSERT INTO `smalltype` VALUES ('41', '枕头', '5');
INSERT INTO `smalltype` VALUES ('42', '围巾', '5');
INSERT INTO `smalltype` VALUES ('43', '背心', '5');
INSERT INTO `smalltype` VALUES ('44', '家居毯', '5');
INSERT INTO `smalltype` VALUES ('45', '旅行箱', '5');
INSERT INTO `smalltype` VALUES ('46', '卫衣', '6');
INSERT INTO `smalltype` VALUES ('47', '男童', '6');
INSERT INTO `smalltype` VALUES ('48', '女童', '6');
INSERT INTO `smalltype` VALUES ('49', '秋衣', '7');
INSERT INTO `smalltype` VALUES ('50', '打底裤', '7');
INSERT INTO `smalltype` VALUES ('51', '内衣', '7');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `userName` varchar(18) NOT NULL,
  `email` varchar(40) NOT NULL,
  `pwd` varchar(18) NOT NULL,
  `vip` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'admin', '', 'admin', '96');
INSERT INTO `user` VALUES ('22', 'guoguoguo', '1256134209@qq.com', 'guoguoguo', '676');
