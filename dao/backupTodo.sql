Create schema if not exists backup;
use backup;
DROP table if exists todo;
CREATE TABLE todo (
    id INT NOT NULL AUTO_INCREMENT,
    todo VARCHAR(150) NOT NULL,
    name VARCHAR(150) NOT NULL,
    isdone boolean default 0,
    PRIMARY KEY (id)
);

insert into todo (id,todo, name,isdone)
    SELECT id,todo,name,isdone FROM test.todo;
