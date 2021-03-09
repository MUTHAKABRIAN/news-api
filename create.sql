CREATE DATABASE news_api;
\c news_api;
CREATE TABLE  department(
id SERIAL PRIMARY KEY ,
userId INTEGER,
name VARCHAR,
description VARCHAR
);

CREATE TABLE users(
id SERIAL PRIMARY KEY ,
departmentId INTEGER,
role VARCHAR,
position VARCHAR,
name VARCHAR
);

CREATE TABLE  news (
id SERIAL  PRIMARY KEY ,
userId INTEGER,
departmentId INTEGER,
type VARCHAR,
content VARCHAR
);


CREATE DATABASE news_api_test WITH TEMPLATE news_api;