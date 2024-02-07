SET search_path=beemylawyer;

CREATE SCHEMA IF NOT EXISTS beemylawyerSchema;

CREATE TABLE IF NOT EXISTS beemylawyerSchema.lawyer(
  id VARCHAR NOT NULL,
  fname VARCHAR(20) NOT NULL,
  lname VARCHAR(20) NOT NULL,
  bio VARCHAR(20) NOT NULL,
  stars NUMERIC NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS beemylawyerSchema.account(
   id VARCHAR NOT NULL,
   useremail VARCHAR(25) NOT NULL,
   password VARCHAR(60) NOT NULL,
   fname VARCHAR(20) NOT NULL,
   lname VARCHAR(20) NOT NULL,
   phonenumber VARCHAR,
   bio VARCHAR,
   cposition VARCHAR,
   skills BYTEA,
   pic VARCHAR,
   signedindate VARCHAR(35),
   signedoutdate VARCHAR(35),
   signedin BOOLEAN,
   stars NUMERIC,
   PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS beemylawyerSchema.request(
    id VARCHAR NOT NULL,
    lawyerid VARCHAR NOT NULL,
    lawyername VARCHAR NOT NULL,
    creationdate VARCHAR(50),
    state VARCHAR NOT NULL,
    clientname VARCHAR NOT NULL,
    phonenumber VARCHAR NOT NULL,
    clientemail VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    PRIMARY KEY(id)
);


