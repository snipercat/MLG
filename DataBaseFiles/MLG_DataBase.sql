SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `MLG` ;
CREATE SCHEMA IF NOT EXISTS `MLG` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `MLG` ;

-- -----------------------------------------------------
-- Table `MLG`.`QUOTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MLG`.`QUOTE` ;

CREATE  TABLE IF NOT EXISTS `MLG`.`QUOTE` (
  `ID` INT NOT NULL ,
  `LOW` DOUBLE NOT NULL ,
  `HIGH` DOUBLE NOT NULL ,
  `OPEN` DOUBLE NOT NULL ,
  `CLOSE` DOUBLE NOT NULL ,
  `VOLUME` DOUBLE NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MLG`.`STOCK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MLG`.`STOCK` ;

CREATE  TABLE IF NOT EXISTS `MLG`.`STOCK` (
  `ID` INT NOT NULL ,
  `ID_QUOTE` INT NOT NULL ,
  `NAME` VARCHAR(200) NOT NULL ,
  `SYMBOL` VARCHAR(200) NOT NULL ,
  `DESCRIPTION` VARCHAR(2000) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `fk_STOCK_QUOTE`
    FOREIGN KEY (`ID_QUOTE` )
    REFERENCES `MLG`.`QUOTE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_STOCK_QUOTE1` ON `MLG`.`STOCK` (`ID_QUOTE` ASC) ;


-- -----------------------------------------------------
-- Table `MLG`.`COMPANY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MLG`.`COMPANY` ;

CREATE  TABLE IF NOT EXISTS `MLG`.`COMPANY` (
  `ID` INT NOT NULL ,
  `ID_STOCK` INT NOT NULL ,
  `NAME` VARCHAR(200) NOT NULL ,
  `SYMBOL` VARCHAR(200) NULL ,
  `DESCRIPTION` VARCHAR(2000) NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `fk_COMPANY_STOCK`
    FOREIGN KEY (`ID_STOCK` )
    REFERENCES `MLG`.`STOCK` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_COMPANY_STOCK1` ON `MLG`.`COMPANY` (`ID_STOCK` ASC) ;


-- -----------------------------------------------------
-- Table `MLG`.`MARKET`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MLG`.`MARKET` ;

CREATE  TABLE IF NOT EXISTS `MLG`.`MARKET` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ID_COMPANY` INT NOT NULL ,
  `NAME` VARCHAR(200) NOT NULL ,
  `NEMO` VARCHAR(200) NOT NULL ,
  `DESCRIPTION` VARCHAR(2000) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `fk_MARKET_COMPANY`
    FOREIGN KEY (`ID_COMPANY` )
    REFERENCES `MLG`.`COMPANY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_MARKET_COMPANY1` ON `MLG`.`MARKET` (`ID_COMPANY` ASC) ;


-- -----------------------------------------------------
-- Table `MLG`.`DATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MLG`.`DATE` ;

CREATE  TABLE IF NOT EXISTS `MLG`.`DATE` (
  `ID` INT NOT NULL ,
  `QUOTE_ID` INT NOT NULL ,
  `DAY` INT NULL ,
  `MONTH` INT NULL ,
  `YEAR` INT NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `fk_DATE_QUOTE`
    FOREIGN KEY (`QUOTE_ID` )
    REFERENCES `MLG`.`QUOTE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DATE_QUOTE1` ON `MLG`.`DATE` (`QUOTE_ID` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
