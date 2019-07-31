INSERT INTO client (client_id, client_name) VALUES (1, 'Test Client 1');
INSERT INTO client (client_id, client_name) VALUES (2, 'Test Client 2');
INSERT INTO client (client_id, client_name) VALUES (3, 'Test Client 3');
INSERT INTO device (device_id, device_model, device_date, device_description, client_id) VALUES (1, 'Device1', '2019-07-12', 'verydamaged1', 1);
INSERT INTO device (device_id, device_model, device_date, device_description, client_id) VALUES (2, 'Device2', '2019-07-13', 'verydamaged2', 1);
INSERT INTO device (device_id, device_model, device_date, device_description, client_id) VALUES (3, 'Device3', '2019-07-14', 'verydamaged3', 2);
