USE master_db;
CREATE TABLE users (
    user_id int not null unique auto_increment primary key,
    username varchar(255) unique not null,
    passwd varchar(255) not null,
    email varchar(255) not null unique,
    lvl int,
    title varchar(255)
);

INSERT INTO users (username, passwd, email, lvl, title) VALUES ('andrc', '123456', 'andc@devco.com', 1, 'Fancy Feet');
INSERT INTO users (username, passwd, email, lvl, title) VALUES ('hugof', '35218', 'hfaria@devco.com', 1, 'Maverick');