-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: TourManager
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id_cate` int(11) NOT NULL AUTO_INCREMENT,
  `nameCate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_cate`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Contact`
--

DROP TABLE IF EXISTS `Contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact` (
  `id_contact` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `content` text NOT NULL,
  `id_member` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contact`),
  KEY `fk_Contact_1_idx` (`type`),
  CONSTRAINT `fk_Contact_1` FOREIGN KEY (`type`) REFERENCES `Member` (`id_member`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Images`
--

DROP TABLE IF EXISTS `Images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Images` (
  `id_img` int(11) NOT NULL AUTO_INCREMENT,
  `nameImages` varchar(100) DEFAULT NULL,
  `size` double DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_img`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Member`
--

DROP TABLE IF EXISTS `Member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `OrderDetails`
--

DROP TABLE IF EXISTS `OrderDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrderDetails` (
  `id_order` int(11) NOT NULL,
  `id_tour` int(11) NOT NULL,
  `totalPrice` double DEFAULT NULL,
  `totalUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_tour`),
  KEY `fk_OrderDetails_2_idx` (`id_tour`),
  CONSTRAINT `fk_OrderDetails_1` FOREIGN KEY (`id_order`) REFERENCES `Orderr` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetails_2` FOREIGN KEY (`id_tour`) REFERENCES `Tour` (`id_tour`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Orderr`
--

DROP TABLE IF EXISTS `Orderr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orderr` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_member` int(11) NOT NULL,
  `orderDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_Order_1_idx` (`id_member`),
  CONSTRAINT `fk_Order_1` FOREIGN KEY (`id_member`) REFERENCES `Member` (`id_member`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Place`
--

DROP TABLE IF EXISTS `Place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Place` (
  `id_place` int(11) NOT NULL AUTO_INCREMENT,
  `namePlace` varchar(100) DEFAULT NULL,
  `summaryPlace` text,
  `id_img` int(11) NOT NULL,
  PRIMARY KEY (`id_place`),
  KEY `fk_Place_1_idx` (`id_img`),
  CONSTRAINT `fk_Place_1` FOREIGN KEY (`id_img`) REFERENCES `Images` (`id_img`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Tour`
--

DROP TABLE IF EXISTS `Tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tour` (
  `id_tour` int(11) NOT NULL AUTO_INCREMENT,
  `nameTour` varchar(500) DEFAULT NULL,
  `content` text,
  `summaryTour` text,
  `departureDate` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `id_place` int(11) DEFAULT NULL,
  `id_cate` int(11) DEFAULT NULL,
  `id_img` int(11) DEFAULT NULL,
  `totalMember` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tour`),
  KEY `fk_Tour_1_idx` (`id_place`),
  KEY `fk_Tour_2_idx` (`id_cate`),
  KEY `fk_Tour_3_idx` (`id_img`),
  CONSTRAINT `fk_Tour_1` FOREIGN KEY (`id_place`) REFERENCES `Place` (`id_place`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tour_2` FOREIGN KEY (`id_cate`) REFERENCES `Category` (`id_cate`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tour_3` FOREIGN KEY (`id_img`) REFERENCES `Images` (`id_img`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-02 21:33:17
