CREATE TABLE `Student` (
  `USN` varchar(11) NOT NULL,
  `Stdname` varchar(45) NOT NULL,
  `rollno` int DEFAULT NULL,
  `attandance` int DEFAULT NULL,
  PRIMARY KEY (`USN`),
  UNIQUE KEY `USN_UNIQUE` (`USN`)
)
