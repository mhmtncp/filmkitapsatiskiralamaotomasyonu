/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : filmbook

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 04/01/2018 17:46:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `book_genre` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `book_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `book_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `book_amount` int(11) NULL DEFAULT NULL,
  `book_rent_price` double(10, 2) NULL DEFAULT NULL,
  `book_purchase_price` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  FULLTEXT INDEX `bookindex`(`book_name`, `book_author`, `book_genre`, `book_publisher`)
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Suç ve Ceza', 'Dostoyevski', 'Klasik', 'askfalsdas', 'Zart Yayınları', 52, 3.00, 10.00);
INSERT INTO `book` VALUES (2, 'Vatan Yahut Silistre', 'Namık Kemal', 'Temel Eser', 'asdaklsfasasdqq', 'Zurt Yayınevi', 20, 2.00, 5.00);
INSERT INTO `book` VALUES (3, 'Peter Pan', 'James Matthew Barrie', 'Temel Eser', 'mdfgdnfkg', 'Zart Yayınları', 21, 4.00, 8.00);
INSERT INTO `book` VALUES (4, 'Yüzüklerin Efendisi', 'J.R.R. Tolkien', 'Klasik', 'Yüzük müzük', 'Cart Yayınları', 12, 6.00, 15.00);

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `film_director` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `film_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `film_amount` int(11) NULL DEFAULT NULL,
  `film_rent_price` double(10, 2) NULL DEFAULT NULL,
  `film_purchase_price` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`film_id`) USING BTREE,
  FULLTEXT INDEX `filmindex`(`film_name`, `film_director`)
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES (1, 'Lord of The Rings', 'sadasd', '2002', 2, 3.00, 13.00);
INSERT INTO `film` VALUES (2, 'G.O.R.A', 'Cem Yılmaz', '2004', 4, 7.00, 12.00);
INSERT INTO `film` VALUES (3, 'A.R.O.G', 'Cem Yılmaz', '2008', 4, 5.00, 9.00);
INSERT INTO `film` VALUES (4, 'SHUTTER ISLAND', 'NURİ BİLGE CEYLAN', '2007', 33, 9.00, 20.00);
INSERT INTO `film` VALUES (5, 'ÇALGI ÇENGİ', 'MAHMUT TUNCER', '2009', 20, 24.00, 42.00);
INSERT INTO `film` VALUES (6, 'SHUTTER ZART', 'ASFAS', '2022', 5, 3.00, 4.00);
INSERT INTO `film` VALUES (7, 'SHUTTER ZURT', 'FASD', '2000', 4, 5.00, 6.00);

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `purchase_type` int(11) NULL DEFAULT NULL,
  `purchase_price` double(10, 2) NULL DEFAULT NULL,
  `product_type` bit(1) NULL DEFAULT NULL,
  `purchase_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (12, 10, 4, 0, 20.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (13, 10, 4, 0, 20.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (14, 10, 1, 0, 10.00, b'1', '2017-12-13');
INSERT INTO `purchase` VALUES (15, 10, 2, 0, 12.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (16, 10, 4, 0, 20.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (17, 10, 3, 0, 8.00, b'1', '2017-12-13');
INSERT INTO `purchase` VALUES (18, 10, 4, 0, 20.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (19, 2, 1, -1, 10.00, b'1', '2017-12-13');
INSERT INTO `purchase` VALUES (20, 2, 2, -1, 5.00, b'1', '2017-12-13');
INSERT INTO `purchase` VALUES (21, 2, 1, -1, 13.00, b'0', '2017-12-13');
INSERT INTO `purchase` VALUES (22, 2, 1, -1, 10.00, b'1', '2017-12-13');
INSERT INTO `purchase` VALUES (23, 10, 2, 0, 12.00, b'0', '2017-12-14');
INSERT INTO `purchase` VALUES (24, 10, 4, 0, 20.00, b'0', '2017-12-14');
INSERT INTO `purchase` VALUES (25, 10, 4, 0, 20.00, b'0', '2017-12-14');
INSERT INTO `purchase` VALUES (26, 10, 5, 0, 42.00, b'0', '2017-12-14');

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent`  (
  `rent_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `rent_price` double(10, 2) NULL DEFAULT NULL,
  `rent_product_type` bit(1) NULL DEFAULT NULL,
  `rent_hire_date` date NULL DEFAULT NULL,
  `rent_withdraw_date` date NULL DEFAULT NULL,
  `rent_withdraw_status` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`rent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rent
-- ----------------------------
INSERT INTO `rent` VALUES (1, 10, 5, 2.00, b'1', '2017-12-13', NULL, NULL);
INSERT INTO `rent` VALUES (2, 10, 3, 5.00, b'0', '2017-12-13', NULL, NULL);
INSERT INTO `rent` VALUES (3, 10, 3, 4.00, b'1', '2017-12-13', NULL, NULL);
INSERT INTO `rent` VALUES (4, 10, 5, 24.00, b'0', '2017-12-13', NULL, NULL);
INSERT INTO `rent` VALUES (5, 10, 2, 2.00, b'1', '2017-12-13', NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `user_first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `user_last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 1);
INSERT INTO `user` VALUES (2, 'Guest', 'Guest', '', '', '', '', -1);
INSERT INTO `user` VALUES (10, 'mhmtncp', '12345', 'Necip', 'KURUAHMET', 'mehmetnecip93@gmail.com', 'Beşiktaş', 0);

SET FOREIGN_KEY_CHECKS = 1;
