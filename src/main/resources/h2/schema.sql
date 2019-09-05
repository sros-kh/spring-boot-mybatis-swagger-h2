CREATE TABLE positions
(
  id SERIAL PRIMARY KEY ,
  position VARCHAR(50) NOT NULL
);

CREATE TABLE staffs
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(25) NOT NULL ,
  gender CHAR NOT NULL ,
  address VARCHAR NULL ,
  active INT NULL ,
  photo VARCHAR NULL,
  pos_id INT REFERENCES positions(id)
);