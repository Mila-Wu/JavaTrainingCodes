/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : online_shopping_mall

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2021-09-12 11:44:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` char(20) NOT NULL,
  `parent_id` char(20) DEFAULT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` char(20) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `sale_price` decimal(10,2) DEFAULT NULL,
  `preferential_price` decimal(10,2) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `click_count` int(11) DEFAULT NULL,
  `sale_amount` int(11) DEFAULT NULL,
  `category_id` char(20) DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for `item_image`
-- ----------------------------
DROP TABLE IF EXISTS `item_image`;
CREATE TABLE `item_image` (
  `id` char(20) NOT NULL,
  `item_id` char(20) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `is_default` tinyint(1) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of item_image
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` char(20) NOT NULL,
  `user_id` char(20) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `pay_on` datetime DEFAULT NULL,
  `deliver_on` datetime DEFAULT NULL,
  `Complete_on` datetime DEFAULT NULL,
  `order_comment` varchar(50) DEFAULT NULL,
  `consignee_name` varchar(50) DEFAULT NULL,
  `consignee_phone` varchar(50) DEFAULT NULL,
  `consignee_address` varchar(50) DEFAULT NULL,
  `payment_id` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` char(20) DEFAULT NULL,
  `item_id` char(20) DEFAULT NULL,
  `order_id` char(20) DEFAULT NULL,
  `sale_price` decimal(10,2) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `order_payment`
-- ----------------------------
DROP TABLE IF EXISTS `order_payment`;
CREATE TABLE `order_payment` (
  `id` char(20) NOT NULL,
  `order_id` char(20) DEFAULT NULL,
  `account_no` varchar(50) DEFAULT NULL,
  `account_name` varchar(50) DEFAULT NULL,
  `payment_status` char(20) DEFAULT NULL,
  `payment_type` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order_payment
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` char(20) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `avaliable` tinyint(1) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(20) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `login_id` varchar(50) NOT NULL,
  `role_id` char(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_consignee`
-- ----------------------------
DROP TABLE IF EXISTS `user_consignee`;
CREATE TABLE `user_consignee` (
  `id` char(20) NOT NULL,
  `user_id` char(20) DEFAULT NULL,
  `consignee_name` varchar(50) DEFAULT NULL,
  `consignee_phone` varchar(50) DEFAULT NULL,
  `consignee_address` varchar(50) DEFAULT NULL,
  `is_default` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_consignee
-- ----------------------------

-- ----------------------------
-- Table structure for `user_shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `user_shopping_cart`;
CREATE TABLE `user_shopping_cart` (
  `id` char(20) NOT NULL,
  `user_id` char(20) DEFAULT NULL,
  `item_id` char(20) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_shopping_cart
-- ----------------------------
