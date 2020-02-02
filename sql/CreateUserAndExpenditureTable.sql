CREATE TABLE `finance_app`.`user_expenditures` (
  `username` varchar(20) NOT NULL,
  `expenditure` float NOT NULL,
  PRIMARY KEY (`username`,`expenditure`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `users_passwords` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
);