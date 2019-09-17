DROP TABLE IF EXISTS client;
CREATE TABLE client (
    client_id INT NOT NULL AUTO_INCREMENT,
    client_name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (client_id)
);

DROP TABLE IF EXISTS device;
CREATE TABLE device (
    device_id INT NOT NULL AUTO_INCREMENT,
    device_name VARCHAR(255) NOT NULL,
    parent_id INT NOT NULL,
    device_date TIMESTAMP NOT NULL,
    device_description VARCHAR(255) NOT NULL,
    PRIMARY KEY (device_id),
    FOREIGN KEY (parent_id) REFERENCES client (client_id)
);