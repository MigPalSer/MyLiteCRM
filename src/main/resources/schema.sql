DROP TABLE IF EXISTS customers;
CREATE TABLE customers ( `name` VARCHAR(20) , `surnames` VARCHAR(40)  , `email` VARCHAR(30) NOT NULL , `phonenumber` INT , PRIMARY KEY (`email`)) ENGINE = InnoDB;