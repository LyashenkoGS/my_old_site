Create schema if not exists test;
use test;
DROP table if exists todo;
CREATE TABLE todo (
    id INT NOT NULL AUTO_INCREMENT,
    todo VARCHAR(150) NOT NULL,
    name VARCHAR(150) NOT NULL,
    isdone boolean default 0,
    PRIMARY KEY (id)
);

insert into todo (todo, name)
values
('Kill Kenedy','agent 47');
insert into todo (todo, name)
values
('Bought geroine to the New Year','Scar face');
insert into todo (todo, name)
values
('Hack pentagon','Showden');
insert into todo (todo, name)
values
('Walk with bear and play balalaika','Putin');