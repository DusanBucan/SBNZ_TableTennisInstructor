INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_REGULAR');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (1,'john@doe.com', true, 'John', 'Doe','2017-10-01 21:58:58', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'john.doe');
INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (2,'jane@doe.com', true, 'Jane', 'Doe','2017-09-01 22:40:00', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'jane.doe');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);

INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (1, 'Forehand topspinn', 'aaaa', 'INTERMEDIATE', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (2, 'Backhand topspinn', 'bbb', 'INTERMEDIATE', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (3, 'Forehand flick', 'cc', 'ADVANCED', 3 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (4, 'Backhand flick', 'dd', 'ADVANCED', 3 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (5, 'Forehand push', 'aaaa', 'BEGINER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (6, 'Backhand push', 'aaaa', 'BEGINER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (7, 'Forehand drive', 'aaaa', 'BEGINER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (8, 'Backhand drive', 'aaaa', 'BEGINER', 2 );

INSERT INTO `user_health` (id, user_id, date, heartbeat, systolic, diastolic, user_health_state) VALUES (1, 1, null , 65, 120, 75, 'UNKNOWN' );


INSERT INTO `training_mistake` (id, description, solution) VALUES (1, 'mistake1', 'solution1');
INSERT INTO `training_mistake` (id, description, solution) VALUES (2, 'mistake2', 'solution2');

INSERT INTO `training_drill` (id, description, repetitons) VALUES (1, 'drill1', 10);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (2, 'drill2', 10);

INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (1,'BEGINNER', 8, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (2,'INTERMEDIATE', 8, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (3,'ADVANCED', 1, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (4,'BEGINNER', 7, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (5,'BEGINNER', 5, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (6,'ADVANCED', 4, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (7,'ADVANCED', 3, 5);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (8,'BEGINNER', 6, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (9,'ADVANCED', 6, 4);



INSERT INTO `training_execution` (id , user_id, training_id, date, training_mark) VALUES (2, 1, 9, null, 'EXCELLENT');
INSERT INTO `training_execution` (id , user_id, training_id, date, training_mark) VALUES (1, 1, 8, null, 'EXCELLENT');