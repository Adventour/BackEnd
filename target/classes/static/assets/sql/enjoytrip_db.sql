-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `addr` VARCHAR(100) NOT NULL,
  `image` VARCHAR(200) NOT NULL,
  `sido_code` INT NOT NULL,
  `gugun_code` INT NOT NULL,
  `latitude` DECIMAL(20,17) NOT NULL,
  `longitude` DECIMAL(20,17) NOT NULL,
  PRIMARY KEY (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`members` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pwd` VARCHAR(150) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_sido` INT NOT NULL,
  `user_gugun` INT NOT NULL,
  `salt` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `subject` VARCHAR(100) NULL,
  `content` VARCHAR(2000) NOT NULL,
  `hit` INT NOT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `boards_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `boards_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`plans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`plans` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `plan_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`plan_id`),
  INDEX `plans_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `plans_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`plan_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`plan_detail` (
  `plan_id` INT NOT NULL,
  `plan_order` INT NOT NULL,
  `content_id` INT NOT NULL,
  `descript` VARCHAR(2000) NOT NULL,
  INDEX `plan_detail_plans_plain_id_fk_idx` (`plan_id` ASC) VISIBLE,
  PRIMARY KEY (`plan_id`, `plan_order`),
  INDEX `plan_detail_attraction_content_id_fk_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `plan_detail_plans_plain_id_fk`
    FOREIGN KEY (`plan_id`)
    REFERENCES `enjoytrip`.`plans` (`plan_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `plan_detail_attraction_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction` (`content_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hot_places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hot_places` (
  `hot_place_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `hot_place_name` VARCHAR(100) NOT NULL,
  `hot_place_addr` VARCHAR(100) NOT NULL,
  `hot_place_image` VARCHAR(200) NULL,
  `latitude` DECIMAL(20,17) NOT NULL,
  `longitude` DECIMAL(20,17) NOT NULL,
  `descript` VARCHAR(2000) NULL,
  PRIMARY KEY (`hot_place_id`),
  INDEX `hot_places_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `hot_places_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`replies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`replies` (
  `reply_id` INT NOT NULL AUTO_INCREMENT,
  `article_no` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `like` INT NOT NULL,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_id`),
  INDEX `replies_boards_articel_no_fk_idx` (`article_no` ASC) VISIBLE,
  INDEX `replies_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `replies_boards_articel_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `enjoytrip`.`board` (`article_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `replies_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`followings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`followings` (
  `following_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `follower_id` VARCHAR(20) NOT NULL,
  `following_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`following_id`),
  INDEX `followings_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `followings_members_follwer_id_fk_idx` (`follower_id` ASC) VISIBLE,
  UNIQUE INDEX `unique_relation` (`user_id` ASC, `follower_id` ASC) VISIBLE,
  CONSTRAINT `followings_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `followings_members_follwer_id_fk`
    FOREIGN KEY (`follower_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
