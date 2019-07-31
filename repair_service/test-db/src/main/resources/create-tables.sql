
DROP TABLE IF EXISTS client;
CREATE TABLE client (
  client_id INT NOT NULL AUTO_INCREMENT,
  client_name VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (client_id)
);

DROP TABLE IF EXISTS device;
CREATE TABLE device (
device_id INT NOT NULL AUTO_INCREMENT,
device_model VARCHAR(255) NOT NULL UNIQUE,
device_date DATE NOT NULL,
device_description VARCHAR(255) NOT NULL,
client_id INT NOT NULL,
PRIMARY KEY (device_id),
    CONSTRAINT device_to_client_foreign_key
    FOREIGN KEY (client_id)
    REFERENCES client (client_id)
);