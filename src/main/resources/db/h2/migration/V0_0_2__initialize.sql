DROP TABLE IF EXISTS city;
CREATE TABLE city(
  id int  PRIMARY KEY AUTO_INCREMENT ,
  name varchar(50) NULL,
  state varchar(50) NULL,
  country varchar(50) NULL
);