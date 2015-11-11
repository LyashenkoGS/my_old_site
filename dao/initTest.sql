create SCHEMA IF NOT EXISTS test;
USE test;
drop table if exists question;
drop table if exists answer;
drop table if exists test;


-- -----------------------------------------------------
-- Table `test`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`test` (
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`));

insert into test values('my_test');
-- -----------------------------------------------------
-- Table `test`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`answer` (
  `name` VARCHAR(45) NOT NULL,
  `question_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`));
insert into answer values('wrong_answer','my_question'); 
insert into answer values('my_right_answer_name','my_question');
-- -----------------------------------------------------
-- Table `test`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`question` (
  `name` VARCHAR(45) NOT NULL,
  `right_answer_name` VARCHAR(45) NULL DEFAULT NULL,
  `test_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`name`));
insert into question values('my_question','my_right_answer_name','my_test');

