-- MySQL dump 10.13  Distrib 8.4.6, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: warehouse
-- ------------------------------------------------------
-- Server version	8.4.6

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `warehouse`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `warehouse` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `warehouse`;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `Company_ID` int NOT NULL,
  `Company_title` char(25) DEFAULT NULL,
  PRIMARY KEY (`Company_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (44008177,'Errickson');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `item_ID` int NOT NULL,
  `amount` int DEFAULT NULL,
  `description` char(25) DEFAULT NULL,
  `Supplier` char(25) DEFAULT NULL,
  `Delivery_Date` date DEFAULT NULL,
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008215 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (10008177,33008177,100,'Rough rider','Toshiba','2008-03-03'),(10008178,33008177,100,'Freler','Ericksson','2008-03-04'),(10008179,33008177,100,'Hells Angel','Bosch','2008-03-05'),(10008180,33008177,100,'Ball','Krupps','2008-03-06'),(10008181,33008177,100,'Hells Angel','Sony','2008-03-07'),(10008182,33008177,100,'Chopper','Sony','2008-03-08'),(10008183,33008177,100,'Slingshot','Amdahl','2008-03-09'),(10008185,33008177,100,' Boss Hoss','Sony','2008-03-09'),(10008186,33008177,100,'Cruiser','Sony','2008-03-10'),(10008187,33008177,100,'Heley','Hoover','2008-03-11'),(10008188,33008177,100,'Free Loadr','IBM','2008-03-12'),(10008189,33008177,100,'Free Rider','IBM','2008-03-13'),(10008190,33008178,100,'HeAngel','Sony','2008-03-03'),(10008191,33008178,100,'Chopp','Sony','2008-03-04'),(10008192,33008178,100,'Slingshot','Amdahl','2008-03-05'),(10008193,33008178,100,' BosHoss','Sony','2008-03-06'),(10008194,33008178,100,'Cruiser','Sony','2008-03-07'),(10008195,33008178,100,'Heley','Hoover','2008-03-07'),(10008200,33008179,100,'HeAngel','Sony','2008-03-03'),(10008201,33008179,100,'Arrow','Sony','2008-03-04'),(10008202,33008179,100,'Slingshot','Amdahl','2008-03-05'),(10008203,33008179,100,'Cruiser','Sony','2008-03-06'),(10008204,33008179,100,' Rough Rider','Toyota','2008-03-07'),(10008205,33008179,100,' Sliders','Opel','2008-03-08'),(10008206,33008180,100,'Wombat out of hell','Krupps','2008-03-03'),(10008207,33008180,100,'Base Liner','Sony','2008-03-04'),(10008208,33008180,100,'Crusher','Digital','2008-03-05'),(10008209,33008180,100,' Boss Ross','Kodak','2008-03-06'),(10008210,33008180,100,' FreeWheeler','Richards','2008-03-07'),(10008211,33008180,100,'Free Spinner','Ericksson','2008-03-08'),(10008212,33008177,100,'Free Rider','IBM','2008-03-13'),(10008213,33008180,100,'Free Spinner1','Ericksson','2008-03-18'),(10008214,33008180,100,'Free Spinner1','Ericksson','2008-03-18');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `Item_ID` int NOT NULL AUTO_INCREMENT,
  `Company_ID` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `itemName` char(25) DEFAULT NULL,
  `Location` char(25) DEFAULT NULL,
  PRIMARY KEY (`Item_ID`,`Company_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33008181 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (33008177,44008177,1200,'Electric Gear','Cork'),(33008178,44008177,600,'Electric Motor','Dublin'),(33008179,44008177,600,'Electric Engine','Mayo'),(33008180,44008177,600,'Electric Engine','PortLaoise');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `User_ID` int NOT NULL,
  `User_Name` char(25) DEFAULT NULL,
  `User_Password` char(25) NOT NULL,
  `Company_ID` int NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (100,'Pio','connuineill123',44008177);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'warehouse'
--

--
-- Dumping routines for database 'warehouse'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-19  1:02:34
