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
  PRIMARY KEY (`id`),
  KEY `I_person_last_name` (`last_name`),
  KEY `I_person_alphabet` (`alphabet`)
) ENGINE=InnoDB AUTO_INCREMENT=2410 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Caridad','Noiseux','217-09-633-91-34','245-73-82','3076','и'),(2,'Aja','Kurr','050-16-703-32-75',NULL,'4206','с'),(3,'Juli','Lettieri',NULL,NULL,'6558','с'),(4,'Lucy','Craan','870-87-278-47-45','163-30-05','0635','в'),(5,'Luise','Diachenko',NULL,NULL,'7150','д'),(6,'Jeni','Fazzinga',NULL,'596-41-94','9111','а'),(7,'Annette','Ballar',NULL,NULL,'1015','л'),(8,'Phillis','Noiseux',NULL,'208-76-82','1221','п'),(9,'Cori','Bening',NULL,'334-23-18','1000','ч'),(10,'Becki','Davydov','711-71-298-62-34','201-31-86','8447','д'),(11,'Robbyn','Cuzzo','713-32-024-34-74','854-40-04','8110','т'),(12,'Brady','Carabello',NULL,'579-11-67','0929','л'),(13,'Miranda','Draa',NULL,'675-65-39','0883','р'),(14,'Gladys','Bedenfield','837-09-058-79-79','164-63-65','5815','к'),(15,'Bree','Hibble',NULL,'391-24-13','6761','п'),(16,'Trisha','Gibb','352-03-665-20-64',NULL,'7936','з'),(17,'Cristophe','Colvard','014-51-574-00-59','230-26-16','5726','а'),(18,'Georgene','Statham','246-88-045-44-26',NULL,'8573','д'),(19,'Alphonso','Elsbury',NULL,'704-08-53',NULL,'т'),(20,'Tyron','Schwartzman',NULL,'771-97-12','8330','в'),(21,'Dennise','Meeds',NULL,'923-90-05','6126','в'),(22,'Alberto','Durol',NULL,'518-28-35','9996','э'),(23,'Shirely','Chiotti','624-95-335-41-05',NULL,'5743','э'),(24,'Rosanna','Kosareff',NULL,NULL,'4402','е'),(25,'Eula','Gwenn',NULL,'206-53-23','1919','х'),(26,'Andera','Germer','913-76-993-36-27','784-85-24',NULL,'с'),(27,'Karly','Baronne',NULL,'545-72-17','1702','а'),(28,'Fiona','Hallie',NULL,'325-10-76','7942','р'),(29,'Dorcas','Gravit',NULL,'264-65-18','7739','в'),(30,'Lakita','Leyh',NULL,'268-96-35','1854','т'),(31,'Sherry','Hewey',NULL,'479-11-60','0165','в'),(32,'Chassidy','Mclilly','065-21-342-37-79','800-23-91','4057','к'),(33,'Lynda','Nivala','252-00-401-99-55','443-83-75','1401','г'),(34,'Francisco','Dorcent','411-61-609-50-47','160-26-68','2286','е'),(35,'Judie','Hojczyk','553-80-764-28-18','539-57-79','8968','к'),(36,'Gregoria','Biersack',NULL,'897-52-78','3407','р');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
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

-- Dump completed on 2017-08-08  9:20:34
