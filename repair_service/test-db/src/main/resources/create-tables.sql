
DROP TABLE IF EXISTS client;
CREATE TABLE client (
  client_id INT NOT NULL AUTO_INCREMENT,
  client_name VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (client_id)
)