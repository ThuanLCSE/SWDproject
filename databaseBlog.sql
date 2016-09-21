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
  `numberOfLike` INT NULL,
  `content` LONGTEXT NULL,
  `imageUrl` LONGTEXT NULL,
  `published` TINYINT(1) NULL,
  `lastUpdateDay` DATETIME NULL,
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
