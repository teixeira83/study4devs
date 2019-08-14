-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: study4devs
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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `first_answer` varchar(200) DEFAULT NULL,
  `fourth_answer` varchar(200) DEFAULT NULL,
  `right_answer` int(11) NOT NULL,
  `second_answer` varchar(200) DEFAULT NULL,
  `third_answer` varchar(200) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(2,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(3,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(4,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(5,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(6,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(7,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(8,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(9,'JAVA','3','6',2,'1','4','Quanto é 2 + 2?'),(10,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(11,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(12,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(13,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(14,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(15,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(16,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(17,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(18,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(19,'JAVASCRIPT','3','6',2,'1','5','Quanto é 2 + 3?'),(20,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(21,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(22,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(23,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(24,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(25,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(26,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(27,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(28,'JAVASCRIPT','3','2',2,'1','6','Quanto é 3 + 3?'),(29,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(30,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(31,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(32,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(33,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(34,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(35,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(36,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(37,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(38,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(39,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(40,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(41,'PHP','3','2',2,'1','6','Quanto é 3 + 3?'),(42,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(43,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(44,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(45,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(46,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(47,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(48,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(49,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(50,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(51,'PYTHON','3','2',2,'1','7','Quanto é 3 + 4?'),(52,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(53,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(54,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(55,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(56,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(57,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(58,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(59,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(60,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(61,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(62,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(63,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?'),(64,'TYPESCRIPT','3','2',2,'1','8','Quanto é 4 + 4?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin` bit(1) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(12) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(12) NOT NULL,
  `points` int(11) NOT NULL,
  `questions_answered` int(11) NOT NULL,
  `right_answers` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,_binary '\0','email4','t','Rafael Teixeira','1',0,0,0),(2,_binary '','email2','a','Rafael Teixeira ADMIN','1',0,0,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_category`
--

DROP TABLE IF EXISTS `student_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_category` (
  `student_id` bigint(20) NOT NULL,
  `categorys` varchar(255) DEFAULT NULL,
  KEY `FKg6gxnwts9w2rq9dtbq3l50rou` (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_category`
--

LOCK TABLES `student_category` WRITE;
/*!40000 ALTER TABLE `student_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_question`
--

DROP TABLE IF EXISTS `student_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_question` (
  `student_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  KEY `FKe8umv4156emxavp70fw9176m2` (`question_id`),
  KEY `FKqy3egyi3eqemxaqblxbjmeo3l` (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_question`
--

LOCK TABLES `student_question` WRITE;
/*!40000 ALTER TABLE `student_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'study4devs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-13 21:33:02
