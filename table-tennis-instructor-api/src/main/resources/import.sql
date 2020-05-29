INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_REGULAR');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (1,'john@doe.com', true, 'John', 'Doe','2017-10-01 21:58:58', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'john.doe');
INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (2,'jane@doe.com', true, 'Jane', 'Doe','2017-09-01 22:40:00', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'jane.doe');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);

INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (1, 'Forehand spinn', 'aaaa', 'INTERMEDIATE', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (2, 'Backhand spinn', 'bbb', 'INTERMEDIATE', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (3, 'Forehand flip', 'cc', 'ADVANCED', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (4, 'Backhand flip', 'dd', 'ADVANCED', 2 );

INSERT INTO `user_health` (id, user_id, date, heartbeat, systolic, diastolic, user_health_state) VALUES (1, 1, null , 65, 120, 60, 'UNKNOWN' );


INSERT INTO `training_mistake` (id, description, solution) VALUES (1, 'mistake1', 'solution1');
INSERT INTO `training_mistake` (id, description, solution) VALUES (2, 'mistake2', 'solution2');

INSERT INTO `training_drill` (id, description, repetitons) VALUES (1, 'drill1', 10);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (2, 'drill2', 10);

INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (1,'BEGINNER', 1, 2);

INSERT INTO `training_execution` (id , user_id, training_id, date, training_mark) VALUES (1, 1, 1, null, 'EXCELLENT');