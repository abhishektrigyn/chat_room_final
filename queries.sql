-- Users table defination
CREATE TABLE `users` (
  `USERID` int(10) unsigned NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PWD` varchar(50) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--  Message table defination
CREATE TABLE `message` (
   `messageid` bigint(20) NOT NULL AUTO_INCREMENT,
   `CONTENT` varchar(50) NOT NULL,
   `USERID` int(10) unsigned DEFAULT NULL,
   `users_userid` bigint(20) DEFAULT NULL,
   PRIMARY KEY (`messageid`),
   KEY `USERID` (`USERID`),
   CONSTRAINT `message_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `users` (`USERID`) ON DELETE CASCADE
 ) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 
 --- insert statement for users 
 
insert into users (userid,username,pwd)  values (5,'john','test')
insert into users (userid,username,pwd)  values (6,'abhishek','test')