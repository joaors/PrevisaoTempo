  
CREATE TABLE previsao
(
  id integer NOT NULL PRIMARY KEY,
  currentlocation character varying(255),
  currenttime character varying(255),
  dewpoint character varying(255),
  pressure character varying(255),
  relativehumidity character varying(255),
  status character varying(255),
  skyconditions character varying(255),
  temperature character varying(255),
  visibility character varying(255),
  wind character varying(255)
);

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;