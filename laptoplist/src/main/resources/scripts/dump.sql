CREATE DATABASE  IF NOT EXISTS `laptopdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `laptopdb`;
-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: laptopdb
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laptop` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `l_model` varchar(45) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `manufacturer` varchar(45) CHARACTER SET latin1 NOT NULL DEFAULT 'Clevo',
  `screen_size` decimal(3,1) NOT NULL DEFAULT '15.6',
  `screen_resolution` varchar(45) CHARACTER SET latin1 NOT NULL DEFAULT '1920x1080',
  `kb_backlight` enum('monochrome','color','none') CHARACTER SET latin1 NOT NULL DEFAULT 'none',
  `cpu` varchar(45) CHARACTER SET latin1 NOT NULL DEFAULT 'Core i7 4700MQ',
  `gpu` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `main_mem` smallint(3) NOT NULL DEFAULT '4',
  `video_mem` double DEFAULT NULL,
  `storage_type` enum('HDD','SSD') CHARACTER SET latin1 NOT NULL DEFAULT 'HDD',
  `storage_size` smallint(4) NOT NULL DEFAULT '500',
  `adapter_power` smallint(3) NOT NULL DEFAULT '150',
  `weight` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`l_id`),
  UNIQUE KEY `l_id` (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` VALUES (1,'w230ss','Clevo',13.3,'1920x1080','monochrome','Core i7 4700MQ','GTX860M',4,2,'SSD',500,120,2.5),(2,'w650sc','Clevo',15.6,'1920x1080','none','Core i7 4700MQ','GTX950M',8,2,'HDD',500,150,2.6),(3,'A401L','ASUS',14.1,'1920x1080','none','Core i5 5200U','GT 940M',4,2,'HDD',500,65,1.8),(4,'p670sg','Clevo',17.3,'2560x1440','color','Core i7 4710HQ','GTX980M',8,6,'SSD',750,180,2.8);
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-28  1:14:24
