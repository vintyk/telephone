-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springbootdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `code_city`
--

DROP TABLE IF EXISTS `code_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_city`
--

LOCK TABLES `code_city` WRITE;
/*!40000 ALTER TABLE `code_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `code_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `number_mobil` varchar(50) DEFAULT NULL,
  `number_city` varchar(255) DEFAULT NULL,
  `number_shot` varchar(255) DEFAULT NULL,
  `alphabet` varchar(1) DEFAULT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `present_position_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `I_person_last_name` (`last_name`),
  KEY `I_person_alphabet` (`alphabet`),
  KEY `FK17v1ehsksepahrads5qcyny6` (`present_position_id`),
  CONSTRAINT `FK17v1ehsksepahrads5qcyny6` FOREIGN KEY (`present_position_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_person_present_position_id` FOREIGN KEY (`present_position_id`) REFERENCES `present_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2450 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (7,'Семен','Ушаков','375-29-566-55-44','','1015','у','Романович',1),(2410,'Рома','Ушаков','','','1015','у','',1),(2411,'Иван','Михалков','','','1015','м','',1),(2412,'Annette','Кушаков','','','1015','к','',1),(2413,'Виталий','Ушаков','375-29-624-47-44','249-96-73','8877','у','Григорьевич',12),(2414,'Annette','Ушаков','','','1015','у','',1),(2415,'Annette','Ушаков','','','1015','у','',1),(2416,'Annette','Ушаков','','','1015','у','',1),(2417,'Annette','Маршаков','','225-55-88','1015','у','Витальевич',11),(2418,'Дмитрий','Ушаков','','265-54-89','1232','у','Григорьевич',1),(2419,'Annette','Ушаков','','','1015','у','',1),(2420,'Annette','Ушаков','','','1015','у','',1),(2421,'Annette','Ушаков','','','1015','у','',1),(2422,'Алексей','Лобанов','','254-99-77','2343','у','Михайлович',11),(2423,'Annette','Ушаков','','','1015','у','',1),(2424,'Annette','Ушаков','','','1015','у','',1),(2425,'Annette','Ушаков','','','1015','у','',1),(2426,'Валентин','Ушаков','','','1015','у','',11),(2427,'Annette','Ушаков','','','1015','у','',2),(2428,'Annette','Ушаков','','','1015','у','',1),(2429,'Илья','Романенко','','265-55-77','1212','у','ЭХдуардович',1),(2430,'Annette','Ушаков','','','1015','у','',1),(2432,'Иван','Михалков','','','1015','м','',1),(2433,'Сантьяго','Князев','','225-55-88','1015','к','Витальевич',2),(2434,'Себастьян','Кац','375-44-585-66-99','223-65-32','112','к','Измаилович',2),(2446,'Себастьян','Кац','375-44-585-66-99','223-65-32','112','к','Измаилович',1),(2449,'Джорж','Абель','','','121','а','Иванович',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `present_position`
--

DROP TABLE IF EXISTS `present_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `present_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_position`
--

LOCK TABLES `present_position` WRITE;
/*!40000 ALTER TABLE `present_position` DISABLE KEYS */;
INSERT INTO `present_position` VALUES (1,'специалист'),(2,'начальник отдела'),(11,'заведующий сектором'),(12,'Директор');
/*!40000 ALTER TABLE `present_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `privilege` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-17 15:07:34
