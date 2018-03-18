# ************************************************************
# Sequel Pro SQL dump
# Version 4529
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: workoutdiary
# Generation Time: 2018-03-18 19:13:23 +0000
# ************************************************************

CREATE DATABASE  IF NOT EXISTS `workoutdiary` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `workoutdiary`;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table equipment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;

INSERT INTO `equipment` (`description`, `name`, `id`)
VALUES
	('brukes til å løfte','Vekter',1),
	('brukes til å ligge på','Benk',2),
	('brukes til å løpe','Tredemølle',3),
	('brukes til å sykle på','Spinningsykkel',4),
	('brukes til å trene på å ro','Ro-maskin',5);

/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exercise
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exercise`;

CREATE TABLE `exercise` (
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;

INSERT INTO `exercise` (`name`, `description`, `id`)
VALUES
	('Benkpress','Ligge på benk og presse',1),
	('Sykle','Sykle på spinningssykkel',2),
	('Ro','Ro på romaskin',3),
	('Løpe','Løpe på tredemølle',4),
	('Markløft','Ha vekt på ryggen, bøy deg',5);

/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exercise_has_equipment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exercise_has_equipment`;

CREATE TABLE `exercise_has_equipment` (
  `Exercise_id` int(11) NOT NULL,
  `Equipment_id` int(11) NOT NULL,
  `kilos` float DEFAULT NULL,
  `sets` int(11) DEFAULT NULL,
  PRIMARY KEY (`Exercise_id`,`Equipment_id`),
  KEY `fk_Exercise_has_Equipment_Equipment1_idx` (`Equipment_id`),
  KEY `fk_Exercise_has_Equipment_Exercise1_idx` (`Exercise_id`),
  CONSTRAINT `fk_Exercise_has_Equipment_Equipment1` FOREIGN KEY (`Equipment_id`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Exercise_has_Equipment_Exercise1` FOREIGN KEY (`Exercise_id`) REFERENCES `exercise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `exercise_has_equipment` WRITE;
/*!40000 ALTER TABLE `exercise_has_equipment` DISABLE KEYS */;

INSERT INTO `exercise_has_equipment` (`Exercise_id`, `Equipment_id`, `kilos`, `sets`)
VALUES
	(1,2,50,10),
	(2,4,0,10),
	(3,5,20,30),
	(4,3,0,10),
	(5,1,30,5);

/*!40000 ALTER TABLE `exercise_has_equipment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exercise_has_exercisegroup
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exercise_has_exercisegroup`;

CREATE TABLE `exercise_has_exercisegroup` (
  `Exercise_id` int(11) NOT NULL,
  `ExerciseGroup_id` int(11) NOT NULL,
  PRIMARY KEY (`Exercise_id`,`ExerciseGroup_id`),
  KEY `fk_Exercise_has_ExerciseGroup_ExerciseGroup1_idx` (`ExerciseGroup_id`),
  KEY `fk_Exercise_has_ExerciseGroup_Exercise1_idx` (`Exercise_id`),
  CONSTRAINT `fk_Exercise_has_ExerciseGroup_Exercise1` FOREIGN KEY (`Exercise_id`) REFERENCES `exercise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Exercise_has_ExerciseGroup_ExerciseGroup1` FOREIGN KEY (`ExerciseGroup_id`) REFERENCES `exercisegroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `exercise_has_exercisegroup` WRITE;
/*!40000 ALTER TABLE `exercise_has_exercisegroup` DISABLE KEYS */;

INSERT INTO `exercise_has_exercisegroup` (`Exercise_id`, `ExerciseGroup_id`)
VALUES
	(2,1),
	(4,1),
	(1,2),
	(5,2),
	(3,3);

/*!40000 ALTER TABLE `exercise_has_exercisegroup` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exercisegroup
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exercisegroup`;

CREATE TABLE `exercisegroup` (
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `exercisegroup` WRITE;
/*!40000 ALTER TABLE `exercisegroup` DISABLE KEYS */;

INSERT INTO `exercisegroup` (`name`, `id`)
VALUES
	('Kondisjontrening',1),
	('Bulking',2),
	('Cardio',3);

/*!40000 ALTER TABLE `exercisegroup` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table workout
# ------------------------------------------------------------

DROP TABLE IF EXISTS `workout`;

CREATE TABLE `workout` (
  `Date` date NOT NULL,
  `startTime` time NOT NULL,
  `shape` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `workout` WRITE;
/*!40000 ALTER TABLE `workout` DISABLE KEYS */;

INSERT INTO `workout` (`Date`, `startTime`, `shape`, `note`, `id`)
VALUES
	('2018-02-12','20:35:00',10,'Ganske god form, følte meg pigg',1),
	('2018-02-13','19:35:00',5,'Midt på tre',2),
	('2018-02-14','20:25:00',6,'Helt ok',3),
	('2018-02-15','20:11:00',10,'Veldig god from, time of my lyfe!',4),
	('2018-02-16','20:59:00',2,'Gikk crap, begynte å bli syk',5);

/*!40000 ALTER TABLE `workout` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table workout_has_exercise
# ------------------------------------------------------------

DROP TABLE IF EXISTS `workout_has_exercise`;

CREATE TABLE `workout_has_exercise` (
  `Workout_id` int(11) NOT NULL,
  `Exercise_id` int(11) NOT NULL,
  `duration` time NOT NULL,
  `performance` int(11) NOT NULL,
  PRIMARY KEY (`Workout_id`,`Exercise_id`),
  KEY `fk_Workout_has_Exercise_Exercise1_idx` (`Exercise_id`),
  KEY `fk_Workout_has_Exercise_Workout1_idx` (`Workout_id`),
  CONSTRAINT `fk_Workout_has_Exercise_Exercise1` FOREIGN KEY (`Exercise_id`) REFERENCES `exercise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Workout_has_Exercise_Workout1` FOREIGN KEY (`Workout_id`) REFERENCES `workout` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `workout_has_exercise` WRITE;
/*!40000 ALTER TABLE `workout_has_exercise` DISABLE KEYS */;

INSERT INTO `workout_has_exercise` (`Workout_id`, `Exercise_id`, `duration`, `performance`)
VALUES
	(1,1,'01:15:00',9),
	(2,2,'00:30:00',6),
	(3,3,'00:52:00',5),
	(4,4,'00:29:00',10),
	(5,5,'00:10:30',2);

/*!40000 ALTER TABLE `workout_has_exercise` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
