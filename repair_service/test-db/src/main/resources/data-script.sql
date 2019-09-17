INSERT INTO client (client_id, client_name) VALUES (1, 'Иванов Иван Иванович');
INSERT INTO client (client_id, client_name) VALUES (2, 'Петров Петр Петрович');
INSERT INTO client (client_id, client_name) VALUES (3, 'Сидоров Петр Иванович');

INSERT INTO device (device_id, device_name, parent_id, device_date, device_description) VALUES (1, 'Ipad Air1', 1, '2019-07-12 12:00:00', 'damaged by water');
INSERT INTO device (device_id, device_name, parent_id, device_date, device_description) VALUES (2, 'Ipad Air2', 1, '2019-07-13 12:00:00', 'broken display');
INSERT INTO device (device_id, device_name, parent_id, device_date, device_description) VALUES (3, 'Ipad Air3', 2, '2019-07-14 12:00:00', 'not charging');
INSERT INTO device (device_id, device_name, parent_id, device_date, device_description) VALUES (4, 'Ipad Air4', 2, '2019-07-15 12:00:00', 'crushed by tank');
INSERT INTO device (device_id, device_name, parent_id, device_date, device_description) VALUES (5, 'Ipad Air5', 2, '2019-07-16 12:00:00', 'battery runs out quickly');