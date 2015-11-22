drop schema if exists test;
create SCHEMA IF NOT EXISTS test;
USE test;

-- -----------------------------------------------------
-- Table `test`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`test` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
insert into test(name) values('my_test');

-- -----------------------------------------------------
-- Table `test`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NULL,
  `test_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_test_idx` (`test_id` ASC),
  CONSTRAINT `fk_question_test`
    FOREIGN KEY (`test_id`)
    REFERENCES `test`.`test` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
insert into question(name,test_id) values('my_question', '1');

-- -----------------------------------------------------
-- Table `test`.`answer_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`answer_type` (
  `id` INT NOT NULL auto_increment,
  `answer_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `answer_type_UNIQUE` (`answer_type` ASC))
ENGINE = InnoDB;
insert into answer_type(answer_type) values('right'),('wrong');
-- -----------------------------------------------------
-- Table `test`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `question_id` INT ,
  `answer_type_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_answer_answer_type`
    FOREIGN KEY (`answer_type_id`)
    REFERENCES `test`.`answer_type` (`id`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_answer_question`
    FOREIGN KEY (`question_id`)
    REFERENCES `test`.`question` (`id`)
    ON DELETE cascade
    ON UPDATE cascade);
insert into answer(name,question_id,answer_type_id) values('wrong_answer1',1,2);
INSERT INTO answer (name, question_id, answer_type_id) VALUES ('wrong_answer2', 1, 2);
INSERT INTO answer (name, question_id,answer_type_id) VALUES ('right_answer', 1, 1);



