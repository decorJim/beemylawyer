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
   signedindate DATE,
   signedoutdate DATE,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS beemylawyerSchema.profil(
   id VARCHAR NOT NULL,
   useremail VARCHAR(25),
   fname VARCHAR(20) NOT NULL,
   lname VARCHAR(20) NOT NULL,
   bio VARCHAR NOT NULL,
   cposition VARCHAR,
   skills BYTEA,
   pic VARCHAR,
   phonenumber VARCHAR NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS beemylawyerSchema.signedin(
   useremail VARCHAR(25) NOT NULL,
   signedindate DATE NOT NULL,
   PRIMARY KEY(useremail)
);

CREATE TABLE IF NOT EXISTS beemylawyerSchema.request(
   id VARCHAR NOT NULL,
   lawyerid VARCHAR(25),
   clientid VARCHAR(25),
   description VARCHAR(200) NOT NULL,
   creationdate DATE NOT NULL,
   state BOOLEAN,
   PRIMARY KEY(id)
);


