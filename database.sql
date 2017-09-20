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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (15,'Биржа'),(16,'УЦ БУТБ'),(17,'ЦБИТ');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

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
  `alphabet` varchar(1) NOT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `present_position_id` int(11) NOT NULL,
  `tree_id` int(11) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `I_person_last_name` (`last_name`),
  KEY `I_person_alphabet` (`alphabet`),
  KEY `FK17v1ehsksepahrads5qcyny6` (`present_position_id`),
  KEY `FK9mkw6u1s0i9tgmimwh65vkc4g` (`tree_id`),
  CONSTRAINT `FK17v1ehsksepahrads5qcyny6` FOREIGN KEY (`present_position_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FK9mkw6u1s0i9tgmimwh65vkc4g` FOREIGN KEY (`tree_id`) REFERENCES `tree` (`id`),
  CONSTRAINT `fk_person_present_position` FOREIGN KEY (`present_position_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_person_tree_id` FOREIGN KEY (`tree_id`) REFERENCES `tree` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2502 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (2473,'Александр','Бобейко','375-29-108-62-66','309-32-98','850','б','Григорьевич',53,68,414),(2474,'Виталий','Ушаков','375-29-624-47-44','309-32-28','865','у','Григорьевич',48,68,404),(2476,'Валерий','Нечай','375-29-110-58-45','309-32-28','858','н','Сергеевич',38,68,402),(2477,'Марина','Рудович','','309-32-58','854','р','Анатольевна',49,68,406),(2478,'Людмила','Царева','','309-32-19','867','х','Игнатьевна',50,68,406),(2479,'Елена','Жукова','','219-05-07','855','е','Леонидовна',51,68,855),(2480,'Екатерина','Науменко','','309-32-28','856','н','Викторовна',47,68,402),(2481,'Артем','Чернышев','','309-32-28','851','ч','Андреевич',47,68,402),(2482,'Аркадий','Саликов','','309-37-94','100','с','Семенович',55,62,232),(2483,'Анатолий','Зарецкий','','228-13-85','102','з','Антонович',56,62,229),(2484,'Ирина','Наркевич','','309-37-80','103','н','Владимировна',57,62,230),(2485,'Сергей','Попудренко','','309-37-76','104','п','Яковлевич',57,62,231),(2486,'Сергей','Мойсейчик','','309-37-68','190','м','Иванович',58,62,217),(2487,'Татьяна','Морякина','','220-58-25(ф)','105','м','Анатольевна',59,62,1),(2488,'Александр','Жуков','','309-37-73','220','е','Валентинович',43,64,220),(2489,'Максим','Левшунов','','309-37-77','221','л','Юрьевич',44,64,221),(2490,'Антон','Зарецкий','','309-32-72','223','з','Анатольевич',60,64,208),(2491,'Владимир','Логвин','','309-37-83','224','л','Петрович',60,64,208),(2492,'Андрей','Бирета','','309-37-21','226','б','Константинович',61,64,209),(2493,'Юрий','Рыжиков','','309-32-25','225','р','Петрович',61,64,209),(2494,'Евгений','Гришенчук','','','222','г','Александрович',47,64,222),(2495,'Роман','Петровский','','219-04-89','820','п','Генадьевич',53,65,NULL),(2496,'Александр','Гуща','','309-32-12','821','г','Вадимович',63,65,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_position`
--

LOCK TABLES `present_position` WRITE;
/*!40000 ALTER TABLE `present_position` DISABLE KEYS */;
INSERT INTO `present_position` VALUES (38,'начальник отдела'),(40,'0'),(41,'специалист 1-й категории'),(42,'специалист 2-й категории'),(43,'начальник управления'),(44,'зам. начальника управления'),(45,'ведущий биржевой маклер'),(46,'ведущий специалист'),(47,'специалист'),(48,'зам. директора'),(49,'главный бухгалтер'),(50,'вед. бухгалтер'),(51,'юрисконсульт'),(52,'основной отдел'),(53,'Директор'),(54,'Руководство'),(55,'Председатель Правления'),(56,'Первый заместитель Председателя Правления'),(57,'заместитель Председателя Правления'),(58,'помощник председателя'),(59,'секретарь приемной'),(60,'вед. спец. по  защите инф.'),(61,'вед. инж. по защите инф.'),(62,'Управление информационной безопасности'),(63,'зам. дир. по тех. вопросам');
/*!40000 ALTER TABLE `present_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tree`
--

DROP TABLE IF EXISTS `tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_id` int(11) NOT NULL,
  `chief_executive_id` int(11) DEFAULT NULL,
  `present_position_1_id` int(11) DEFAULT NULL,
  `present_position_2_id` int(11) DEFAULT NULL,
  `present_position_3_id` int(11) DEFAULT NULL,
  `present_position_4_id` int(11) DEFAULT NULL,
  `present_position_5_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtcotahgh7ypjhcjwr8ey9ns4t` (`branch_id`),
  KEY `FKjed8d2kn7wiooy5rlfiqsee21` (`chief_executive_id`),
  KEY `FKef31jd8neupsplh6lqatoj3np` (`present_position_1_id`),
  KEY `FKjs5x0k58y9a7m0nh3uf1u9gow` (`present_position_2_id`),
  KEY `FKr0qmrk2d557be0d72hbcl17f0` (`present_position_3_id`),
  KEY `FKejs1oqawp36nvu5vcqifkuwck` (`present_position_4_id`),
  KEY `FK3k5o782olppoy10pqxfh0fqdp` (`present_position_5_id`),
  CONSTRAINT `FK3k5o782olppoy10pqxfh0fqdp` FOREIGN KEY (`present_position_5_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKef31jd8neupsplh6lqatoj3np` FOREIGN KEY (`present_position_1_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKejs1oqawp36nvu5vcqifkuwck` FOREIGN KEY (`present_position_4_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKjed8d2kn7wiooy5rlfiqsee21` FOREIGN KEY (`chief_executive_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKjs5x0k58y9a7m0nh3uf1u9gow` FOREIGN KEY (`present_position_2_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKr0qmrk2d557be0d72hbcl17f0` FOREIGN KEY (`present_position_3_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `FKtcotahgh7ypjhcjwr8ey9ns4t` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  CONSTRAINT `fk_tree_branch_id_branch_id` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  CONSTRAINT `fk_tree_chief_executive_id_present_position_id` FOREIGN KEY (`chief_executive_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_tree_present_position_1_id_present_position_id` FOREIGN KEY (`present_position_1_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_tree_present_position_2_id_present_position_id` FOREIGN KEY (`present_position_2_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_tree_present_position_3_id_present_position_id` FOREIGN KEY (`present_position_3_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_tree_present_position_4_id_present_position_id` FOREIGN KEY (`present_position_4_id`) REFERENCES `present_position` (`id`),
  CONSTRAINT `fk_tree_present_position_5_id_present_position_id` FOREIGN KEY (`present_position_5_id`) REFERENCES `present_position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tree`
--

LOCK TABLES `tree` WRITE;
/*!40000 ALTER TABLE `tree` DISABLE KEYS */;
INSERT INTO `tree` VALUES (62,15,55,54,40,40,40,40),(64,15,55,62,40,40,40,40),(65,17,53,54,40,40,40,40),(68,16,53,52,40,40,40,40);
/*!40000 ALTER TABLE `tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `privilege` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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

-- Dump completed on 2017-09-20 13:46:25
