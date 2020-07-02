-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tweeter
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `country` varchar(31) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `encrypted_password` varchar(60) NOT NULL,
  `first_name` varchar(31) NOT NULL,
  `last_name` varchar(63) NOT NULL,
  `location` varchar(31) DEFAULT NULL,
  `modified` datetime(6) DEFAULT NULL,
  `postal_address` varchar(63) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `user_handle` varchar(255) NOT NULL,
  `full_name` varchar(52) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_63fc5vxth216eec083ji8ol4d` (`user_handle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,'joseph_carn@gmail.com',_binary '','pass123','Joseph','Carn',NULL,NULL,NULL,NULL,'josephcarn234',''),(2,NULL,NULL,NULL,'charles34@gmail.com',_binary '','password123','Charles','Babbage',NULL,NULL,NULL,NULL,'Charles34',''),(3,NULL,NULL,NULL,'raiza.wilson@gmail.com',_binary '','password123','Raiza','Wilson',NULL,NULL,NULL,NULL,'Raiza',''),(5,NULL,NULL,NULL,'sowmiyas@gmail.com',_binary '','password123','Sowmiya','Shaker',NULL,NULL,NULL,NULL,'SowmiyaShaker',''),(8,NULL,NULL,NULL,'demo.test@gmail.com',_binary '','password123','demo','test',NULL,NULL,NULL,NULL,'demoTest',''),(9,NULL,NULL,NULL,'hello.hai@gmal.com',_binary '','password123','hello','hai',NULL,NULL,NULL,NULL,'helloHi',''),(12,NULL,NULL,NULL,'tu@gmail.com',_binary '','pass123','testing','user',NULL,NULL,NULL,NULL,'testing',''),(13,NULL,NULL,NULL,'abc@gmail.com',_binary '','abc@123','Cha','A',NULL,NULL,NULL,NULL,'cha_123',''),(18,NULL,NULL,NULL,'abc123@gmail.com',_binary '','abc@123','abc','Abc',NULL,NULL,NULL,NULL,'abc_123',''),(21,NULL,NULL,NULL,'amvn@gmail.com',_binary '','amvn123','amvn','m',NULL,NULL,NULL,NULL,'amvn123',''),(23,NULL,NULL,NULL,'qwe@gmail.com',_binary '','qwe123','qwe','asd',NULL,NULL,NULL,NULL,'qwe123',''),(25,NULL,NULL,NULL,'abmn123@gmail.com',_binary '','abmn123','abmn','M',NULL,NULL,NULL,NULL,'abmn123',''),(28,NULL,NULL,NULL,'abmno123@gmail.com',_binary '','abmno123','abmno','M',NULL,NULL,NULL,NULL,'abmno123',''),(29,NULL,NULL,NULL,'abcde@gmail.com',_binary '','abcde123','abcd','e',NULL,NULL,NULL,NULL,'abcd123',''),(31,NULL,NULL,NULL,'abcdee@gmail.com',_binary '','abcdee123','abcde','e',NULL,NULL,NULL,NULL,'abcde123',''),(32,NULL,NULL,NULL,'abc12345@gmail.com',_binary '','abc12345','abc','D',NULL,NULL,NULL,NULL,'abc12345',''),(33,NULL,NULL,NULL,'anmcd@yahoo.in',_binary '','anmcd123','anmc','D',NULL,NULL,NULL,NULL,'anmcd123',''),(34,NULL,NULL,NULL,'amncd@yahoo.in',_binary '','amncd123','amncd','E',NULL,NULL,NULL,NULL,'amncd123',''),(36,NULL,NULL,NULL,'qwerty@yahoo.in',_binary '','qwerty123','qwerty','Q',NULL,NULL,NULL,NULL,'qwerty','qwerty Q');
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

-- Dump completed on 2020-07-02 14:52:53
