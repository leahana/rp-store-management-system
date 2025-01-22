/*
 Navicat Premium Data Transfer

 Source Server         : local-docker-8033
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : courtyard_wu

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 22/01/2025 11:02:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `id` varchar(255) NOT NULL COMMENT '评论ID',
  `user_id` varchar(255) NOT NULL COMMENT '用户ID (关联用户表中的id，表示评论由哪个用户发出)',
  `shop_id` varchar(255) NOT NULL COMMENT '店铺ID (关联店铺表中的id，表示评论属于哪个店铺)',
  `comment_text` text NOT NULL COMMENT '评论内容',
  `rating` int DEFAULT NULL COMMENT '评分 (1到5星)',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  CONSTRAINT `t_comments_chk_1` CHECK ((`rating` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表：每条评论包含用户、店铺和评论内容，通过user_id和shop_id与用户表、店铺表关联。';

-- ----------------------------
-- Table structure for t_products
-- ----------------------------
DROP TABLE IF EXISTS `t_products`;
CREATE TABLE `t_products` (
  `id` varchar(255) NOT NULL COMMENT '商品ID',
  `shop_id` varchar(255) NOT NULL COMMENT '店铺ID (关联店铺表中的id，表示商品属于哪个店铺)',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `description` text COMMENT '商品描述',
  `picture` text COMMENT '图片地址',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。';

-- ----------------------------
-- Table structure for t_shops
-- ----------------------------
DROP TABLE IF EXISTS `t_shops`;
CREATE TABLE `t_shops` (
  `id` varchar(255) NOT NULL COMMENT '店铺ID',
  `shop_name` varchar(255) NOT NULL COMMENT '店铺名称',
  `owner_id` varchar(255) NOT NULL COMMENT '店铺管理员ID (关联用户表中的id，表示店铺管理员)',
  `description` text COMMENT '店铺描述',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺表：包含店铺信息，每个店铺由一个用户管理，用户通过owner_id字段关联。';

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` varchar(255) NOT NULL COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `role` varchar(50) DEFAULT NULL COMMENT '用户角色 (如普通用户、店铺管理员等)',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表：包含所有用户的信息，每个用户可以评论、管理店铺。';

SET FOREIGN_KEY_CHECKS = 1;
