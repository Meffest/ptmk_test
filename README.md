# ptmk_test
Sql-запрос для создания базы :
CREATE TABLE TEST.USERS (
  ID INT NOT NULL AUTO_INCREMENT,
  USER_NAME VARCHAR(255) NOT NULL, 
  birthDate TIMESTAMP,
  sex VARCHAR(255),
  PRIMARY KEY (ID));