-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: Routine
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.17.10.1

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
-- Table structure for table `class_room1`
--

DROP TABLE IF EXISTS `class_room1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_room1` (
  `id` int(11) NOT NULL,
  `8to9` varchar(10) DEFAULT NULL,
  `9to10` varchar(10) DEFAULT NULL,
  `10to11` varchar(10) DEFAULT NULL,
  `11to12` varchar(10) DEFAULT NULL,
  `1to2` varchar(10) DEFAULT NULL,
  `2to3` varchar(10) DEFAULT NULL,
  `3to4` varchar(10) DEFAULT NULL,
  `4to5` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room1`
--

LOCK TABLES `class_room1` WRITE;
/*!40000 ALTER TABLE `class_room1` DISABLE KEYS */;
INSERT INTO `class_room1` VALUES (1,'cs240','cs252','cs210','NULL','cs330','cs306','cs362','cs103'),(2,NULL,NULL,NULL,'NULL',NULL,NULL,NULL,NULL),(3,'cs240','cs252','cs210','NULL','cs330','cs306','cs362','cs103'),(4,NULL,NULL,NULL,'NULL',NULL,NULL,NULL,'cs103'),(5,'cs240','cs252','cs210','NULL','cs330','cs306','cs362','cs103');
/*!40000 ALTER TABLE `class_room1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_room2`
--

DROP TABLE IF EXISTS `class_room2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_room2` (
  `id` int(11) NOT NULL,
  `8to9` varchar(10) DEFAULT NULL,
  `9to10` varchar(10) DEFAULT NULL,
  `10to11` varchar(10) DEFAULT NULL,
  `11to12` varchar(10) DEFAULT NULL,
  `1to2` varchar(10) DEFAULT NULL,
  `2to3` varchar(10) DEFAULT NULL,
  `3to4` varchar(10) DEFAULT NULL,
  `4to5` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room2`
--

LOCK TABLES `class_room2` WRITE;
/*!40000 ALTER TABLE `class_room2` DISABLE KEYS */;
INSERT INTO `class_room2` VALUES (1,'ec260','ec251','ec243','ec103','ec381','ec361','ec353','ec354'),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ec260','ec251','ec243','ec103','ec381','ec361','ec353','ec354'),(4,NULL,NULL,NULL,'ec103',NULL,NULL,NULL,'ec354'),(5,'ec260','ec251','ec243','ec103','ec381','ec361','ec353','ec354');
/*!40000 ALTER TABLE `class_room2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cse_lab`
--

DROP TABLE IF EXISTS `cse_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cse_lab` (
  `id` int(11) NOT NULL,
  `8to9` varchar(10) DEFAULT NULL,
  `9to10` varchar(10) DEFAULT NULL,
  `10to11` varchar(10) DEFAULT NULL,
  `11to12` varchar(10) DEFAULT NULL,
  `1to2` varchar(10) DEFAULT NULL,
  `2to3` varchar(10) DEFAULT NULL,
  `3to4` varchar(10) DEFAULT NULL,
  `4to5` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cse_lab`
--

LOCK TABLES `cse_lab` WRITE;
/*!40000 ALTER TABLE `cse_lab` DISABLE KEYS */;
INSERT INTO `cse_lab` VALUES (1,'cs300','cs300','cs300',NULL,NULL,'cs200','cs200','cs200'),(2,'cs331','cs331','cs331',NULL,'cs241','cs241','cs241','cs241'),(3,'cs111','cs111','cs111',NULL,NULL,NULL,NULL,NULL),(4,'cs341','cs341','cs341',NULL,'cs253','cs253','cs253','cs253'),(5,'cs300','cs300','cs300',NULL,NULL,'cs200','cs200','cs200');
/*!40000 ALTER TABLE `cse_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ece_lab`
--

DROP TABLE IF EXISTS `ece_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ece_lab` (
  `id` int(11) NOT NULL,
  `8to9` varchar(10) DEFAULT NULL,
  `9to10` varchar(10) DEFAULT NULL,
  `10to11` varchar(10) DEFAULT NULL,
  `11to12` varchar(10) DEFAULT NULL,
  `1to2` varchar(10) DEFAULT NULL,
  `2to3` varchar(10) DEFAULT NULL,
  `3to4` varchar(10) DEFAULT NULL,
  `4to5` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ece_lab`
--

LOCK TABLES `ece_lab` WRITE;
/*!40000 ALTER TABLE `ece_lab` DISABLE KEYS */;
INSERT INTO `ece_lab` VALUES (1,'ec362','ec362','ec362',NULL,NULL,'ec252','ec252','ec252'),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ec372','ec372','ec372',NULL,'ec244','ec244','ec244',NULL),(4,'ec111','ec111','ec111',NULL,NULL,NULL,NULL,NULL),(5,'ec382','ec382','ec382',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ece_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `subject_code` varchar(10) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `professor_code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES ('cs240',6,1),('cs330',6,1),('cs252',6,2),('cs306',6,2),('cs210',6,3),('ec381',6,4),('ec260',6,5),('ec361',6,5),('ec251',8,6),('ec353',6,6),('ec354',6,7),('ec243',6,7),('cs362',6,8),('cs103',8,8),('ec103',8,4),('cs241',4,0),('cs253',4,0),('cs200',6,0),('cs331',3,0),('cs341',3,0),('cs300',6,0),('cs111',3,0),('ec111',3,0),('ec252',3,0),('ec244',3,0),('ec362',3,0),('ec372',3,0),('ec382',3,0),('ec352',3,0);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-22 11:04:55
