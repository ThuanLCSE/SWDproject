-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema blog
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `fullname` VARCHAR(60) NULL,
  `active` TINYINT(1) NULL,
  `profilePictureUrl` LONGTEXT NULL,
  `totalBlog` INT NULL,
  `password` VARCHAR(40) NULL,
  `role` VARCHAR(20) NULL,
  `createDay` DATETIME NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PublishedBlog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PublishedBlog` (
  `blogID` INT NOT NULL AUTO_INCREMENT,
  `publishedDay` DATETIME NULL,
  `numberOfComment` INT NULL,
  `title` VARCHAR(80) NULL,
  `numberOfLike` INT NULL,
  `content` LONGTEXT NULL,
  `imageUrl` LONGTEXT NULL,
  `published` TINYINT(1) NULL,
  `lastUpdateDay` DATETIME NULL,
  `authorName1` LONGTEXT NULL,
  `userID` INT NOT NULL,
  PRIMARY KEY (`blogID`),
  INDEX `fk_PublishedBlog_User1_idx` (`userID` ASC),
  CONSTRAINT `fk_PublishedBlog_User1`
    FOREIGN KEY (`userID`)
    REFERENCES `mydb`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BlogLike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BlogLike` (
  `userID` INT NOT NULL,
  `blogID` INT NOT NULL,
  INDEX `fk_BlogLike_User_idx` (`userID` ASC),
  INDEX `fk_BlogLike_PublishedBlog1_idx` (`blogID` ASC),
  PRIMARY KEY (`userID`, `blogID`),
  CONSTRAINT `fk_BlogLike_User`
    FOREIGN KEY (`userID`)
    REFERENCES `mydb`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BlogLike_PublishedBlog1`
    FOREIGN KEY (`blogID`)
    REFERENCES `mydb`.`PublishedBlog` (`blogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Category` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`CategoryID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BlogCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BlogCategory` (
  `BlogTitle` VARCHAR(80) NULL,
  `CategoryID` INT NOT NULL,
  `blogID` INT NOT NULL,
  INDEX `fk_BlogCategory_Category1_idx` (`CategoryID` ASC),
  INDEX `fk_BlogCategory_PublishedBlog1_idx` (`blogID` ASC),
  PRIMARY KEY (`CategoryID`, `blogID`),
  CONSTRAINT `fk_BlogCategory_Category1`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `mydb`.`Category` (`CategoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BlogCategory_PublishedBlog1`
    FOREIGN KEY (`blogID`)
    REFERENCES `mydb`.`PublishedBlog` (`blogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BlogComment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BlogComment` (
  `content` LONGTEXT NULL,
  `commentTime` DATETIME NULL,
  `userID` INT NOT NULL,
  `blogID` INT NOT NULL,
  PRIMARY KEY (`userID`, `blogID`),
  INDEX `fk_BlogComment_User1_idx` (`userID` ASC),
  INDEX `fk_BlogComment_PublishedBlog1_idx` (`blogID` ASC),
  CONSTRAINT `fk_BlogComment_User1`
    FOREIGN KEY (`userID`)
    REFERENCES `mydb`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BlogComment_PublishedBlog1`
    FOREIGN KEY (`blogID`)
    REFERENCES `mydb`.`PublishedBlog` (`blogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('1', 'Ngoc', 'Son Ngoc', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('2', 'Thuan', 'Minh Thuan', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('3', 'Quan', 'Ki Quan', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('4', 'Hung', 'Manh Hung', '123', '0', '123456', 'member', '2016/09/09');


INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`,`title` , `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('1', '2016/09/09', '0', '0','Long time ago', 'ngay xa xam', '123', '0', '2016/09/09', '1');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`,`title`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('2', '2016/09/15', '0', '0','My memory', 'nho ki niem xua', '123', '1', '2016/10/13', '2');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`,`title`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('3', '2016/10/09', '0', '0','Study abroad' ,'Hoc tap tot', '135', '0', '2016/10/11', '4');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`,`title`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('4', '2016/11/11', '0', '0','Stf off', 'Ki luat tot', '89', '1', '2016/12/03', '3');


INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('1', 'Thu Vien');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('2', 'Truong hoc');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('3', 'Lop Hoc');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('4', 'Thanh pho');

insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('1','2','Long time ago');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('1','3','Long time ago');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('1','4','Long time ago');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('2','1','My memory');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('2','4','My memory');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('3','1','Study abroad');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('3','3','Study abroad');
insert Into `blogcategory` (`CategoryID`, `blogID`,`BlogTitle`) values ('4','3','Stf off');
UPDATE `mydb`.`user` SET `active`='1' WHERE `userID`='1';
UPDATE `mydb`.`user` SET `active`='1' WHERE `userID`='2';
UPDATE `mydb`.`user` SET `active`='1' WHERE `userID`='3';
UPDATE `mydb`.`user` SET `active`='1' WHERE `userID`='4';
UPDATE `mydb`.`publishedblog` SET `authorName1`='Son Ngoc' WHERE `blogID`='1';
UPDATE `mydb`.`publishedblog` SET `authorName1`='Minh Thuan' WHERE `blogID`='2';
UPDATE `mydb`.`publishedblog` SET `authorName1`='Manh Hung' WHERE `blogID`='3';
UPDATE `mydb`.`publishedblog` SET `authorName1`='Ki Quan' WHERE `blogID`='4';
