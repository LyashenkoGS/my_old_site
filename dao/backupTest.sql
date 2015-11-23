create SCHEMA IF NOT EXISTS backup;
USE backup;
DROP  TABLE if EXISTS  answer;
DROP  TABLE if EXISTS  answer_type;
DROP  TABLE if EXISTS  question;
DROP  TABLE if EXISTS  test;

-- -----------------------------------------------------
-- Table `test`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup`.`test` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
insert into backup.test(id,name)
SELECT id,name FROM
  test.test;


-- -----------------------------------------------------
-- Table `backup`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup`.`question` (
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
insert into backup.question(id,name,test_id)
SELECT id,name,test_id
FROM test.question;

-- -----------------------------------------------------
-- Table `backup`.`answer_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup`.`answer_type` (
  `id` INT NOT NULL auto_increment,
  `answer_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `answer_type_UNIQUE` (`answer_type` ASC))
ENGINE = InnoDB;
insert into backup.answer_type(answer_type) values('right'),('wrong');
-- -----------------------------------------------------
-- Table `test`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup`.`answer` (
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
INSERT INTO backup.answer (id,name, question_id,answer_type_id)
SELECT id,name,question_id,answer_type_id
FROM test.answer;



