/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : test1227

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 08/01/2022 11:55:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, '红色警戒');
INSERT INTO `game` VALUES (2, '反恐精英');
INSERT INTO `game` VALUES (3, '使命召唤');
INSERT INTO `game` VALUES (4, '穿越火线');
INSERT INTO `game` VALUES (5, '英雄联盟');
INSERT INTO `game` VALUES (6, '全球攻势');
INSERT INTO `game` VALUES (7, '人间地狱');
INSERT INTO `game` VALUES (8, '反恐精英');
INSERT INTO `game` VALUES (9, '极品飞车');
INSERT INTO `game` VALUES (10, 'QQ飞车');
INSERT INTO `game` VALUES (11, '劲舞团');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, 'Java', 0);
INSERT INTO `major` VALUES (2, 'JDBC', 1);
INSERT INTO `major` VALUES (3, 'Spring', 1);
INSERT INTO `major` VALUES (4, 'maven', 1);
INSERT INTO `major` VALUES (5, 'boot', 1);
INSERT INTO `major` VALUES (6, 'cloud', 1);
INSERT INTO `major` VALUES (7, '前端', 0);
INSERT INTO `major` VALUES (8, 'HTML', 7);
INSERT INTO `major` VALUES (9, 'css', 7);
INSERT INTO `major` VALUES (10, 'js', 7);
INSERT INTO `major` VALUES (11, 'ajax', 7);
INSERT INTO `major` VALUES (12, 'vue', 7);
INSERT INTO `major` VALUES (13, 'nodejs', 7);
INSERT INTO `major` VALUES (14, '平面设计', 0);
INSERT INTO `major` VALUES (15, 'PS', 14);
INSERT INTO `major` VALUES (16, 'RGB', 14);
INSERT INTO `major` VALUES (17, '绘图', 14);
INSERT INTO `major` VALUES (18, 'adobe', 14);

-- ----------------------------
-- Table structure for stu_game_relation
-- ----------------------------
DROP TABLE IF EXISTS `stu_game_relation`;
CREATE TABLE `stu_game_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_game_relation
-- ----------------------------
INSERT INTO `stu_game_relation` VALUES (130, 59, 3);
INSERT INTO `stu_game_relation` VALUES (131, 59, 6);
INSERT INTO `stu_game_relation` VALUES (132, 59, 7);
INSERT INTO `stu_game_relation` VALUES (135, 60, 2);
INSERT INTO `stu_game_relation` VALUES (136, 60, 3);

-- ----------------------------
-- Table structure for stu_major_relation
-- ----------------------------
DROP TABLE IF EXISTS `stu_major_relation`;
CREATE TABLE `stu_major_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_major_relation
-- ----------------------------
INSERT INTO `stu_major_relation` VALUES (52, 59, 1, 3);
INSERT INTO `stu_major_relation` VALUES (53, 60, 1, 3);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (59, '少帅', '/imgs2021/12/29/08/07/1.jpg', 36, 1, '泡妞');
INSERT INTO `student` VALUES (60, '张三', '/imgs2022/01/03/08/01/2.jpg', 3213, 1, '323333');

SET FOREIGN_KEY_CHECKS = 1;
