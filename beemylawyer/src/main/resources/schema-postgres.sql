SET search_path=beemylawyer;

CREATE TABLE IF NOT EXISTS lawyer(
  id INT NOT NULL,
  fname INT NOT NULL,
  lname INT NOT NULL,
  bio INT NOT NULL,
  stars INT NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS account(
   id VARCHAR NOT NULL,
   useremail VARCHAR NOT NULL,
   password VARCHAR NOT NULL,
   fname VARCHAR NOT NULL,
   lname VARCHAR NOT NULL,
   phonenumber VARCHAR,
   bio VARCHAR,
   cposition VARCHAR,
   skills BYTEA,
   pic VARCHAR,
   signedindate VARCHAR,
   signedoutdate VARCHAR,
   signedin BOOLEAN,
   stars INT,
   PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS request(
    id VARCHAR NOT NULL,
    lawyerid VARCHAR NOT NULL,
    lawyername VARCHAR NOT NULL,
    creationdate VARCHAR,
    state VARCHAR NOT NULL,
    clientname VARCHAR NOT NULL,
    phonenumber VARCHAR NOT NULL,
    clientemail VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    PRIMARY KEY(id)
);


