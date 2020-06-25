-- MySQL dump 10.13  Distrib 5.7.30, for macos10.14 (x86_64)
--
-- Host: localhost    Database: order_system
-- ------------------------------------------------------
-- Server version	5.7.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'管理用アカウント','5EB0064FAEE402AE0284C2D1C418446257A860F7BC275D49FBDD7221C201ADAE');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKekc536bhhko76eelmpwcnsg5s` (`shop_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (1,'','唐揚げ',398,1),(2,'美味しい','唐揚げ',298,1),(3,'美味しい','フライドポテト',240,2),(5,'出来立てをお届け','焼きそば',450,1),(6,'','ペペロンチーノ',800,5),(7,'','アラビアータ',900,5),(8,'','ボンゴレビアンコ',950,5),(9,'アゴ出汁を使用した香り高いラーメン','醤油ラーメン',800,3),(10,'かつ200g','カツ丼',1030,2),(11,'','味噌ラーメン',890,3),(12,'','塩ラーメン',890,3),(13,'熱々ハンバーグ','ハンバーグ',1000,6),(14,'','ビール',480,6),(15,'','枝豆',380,7),(16,'','落花生',400,7),(17,'ひやのみ','日本酒',700,7);
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `denwa` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `menu_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmkjklkcop7gfy47xu3i7aod7w` (`menu_id`),
  KEY `FK21gttsw5evi5bbsvleui69d7r` (`shop_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,'足立区梅島','828828','テスト',3,'2020-06-21 00:51:45',5,1),(3,'足立区足立','0120888888','テスト',1,'2020-06-21 00:56:19',2,1),(4,'足立区足立','828828','テスト',1,'2020-06-21 00:57:29',3,2),(5,'足立区足立','09060477541','テスト',1,'2020-06-21 01:01:58',1,1),(7,'足立区千住1-0-90','09009090909','テスト',2,'2020-06-21 19:41:43',12,3),(8,'足立区千住0-0-0','0120000000','テスト',1,'2020-06-21 19:51:14',13,6);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `area` int(11) NOT NULL,
  `denwa` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `info` longtext,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (2,'足立区梅島',4,'0120888888','aaa@aaa','テスト用アカウント','テストアカウント','5EB0064FAEE402AE0284C2D1C418446257A860F7BC275D49FBDD7221C201ADAE'),(3,'足立区千住0-0-0',1,'0120000000','ramen@ramen.com','醤油ラーメンがおすすめ','ラーメン店','C38DC17D83D46C64ADB6B16ECA9435B6239F18243E067A0434AC89C4536532BC'),(7,'足立区竹の塚0-00',5,'0120000003','izakaya@izakaya.com','','居酒屋','C1B3F4334AEC3EECD35144A6003046F4EDEF182458D773AE086F763A955E0B4B'),(5,'足立区綾瀬0-0',2,'0120000001','pasta@pasta.com','ボンゴレビアンコがおすすめ','パスタ店','6A9F44A531F2D8E78EBB9A5793630CDECF4E3FEB30E69F3ECE49472BBE349AD0'),(6,'足立区六町0-0',3,'0120000002','hamberg@hamberg.com','','ハンバーグ店','EB3E68BCFBE6DD68BA48522FDC9BDA31BA3087F24A1C9808B44DFA2781850297');
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-24  0:35:05
