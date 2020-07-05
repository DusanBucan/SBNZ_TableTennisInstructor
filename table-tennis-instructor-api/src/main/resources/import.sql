INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_REGULAR');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (1,'john@doe.com', true, 'John', 'Doe','2017-10-01 21:58:58', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'john.doe');
INSERT INTO `users` (id, email, enabled, first_name, last_name, last_password_reset_date, password, username) VALUES (2,'jane@doe.com', true, 'Jane', 'Doe','2017-09-01 22:40:00', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'jane.doe');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);

INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (1, 'Forehand topspinn', 'very powerfull', 'INTERMEDIATE', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (2, 'Backhand topspinn', 'very powerfull', 'INTERMEDIATE', 1 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (3, 'Forehand flick', 'powerfull skill', 'ADVANCED', 3 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (4, 'Backhand flick', 'powerfull skill', 'ADVANCED', 3 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (5, 'Forehand push', 'good skill', 'BEGINNER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (6, 'Backhand push', 'good skill', 'BEGINNER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (7, 'Forehand drive', 'average skill', 'BEGINNER', 2 );
INSERT INTO `skill` (skill_id, name, execution_description, skill_level, skill_group) VALUES (8, 'Backhand drive', 'average skill', 'BEGINNER', 2 );

INSERT INTO `user_health` (id, user_id, date, heartbeat, systolic, diastolic, user_health_state) VALUES (1, 1, null , 65, 120, 75, 'UNKNOWN' );

-- greske na treninzima
INSERT INTO `training_mistake` (id, description, solution) VALUES (1, 'too wide stance', 'close distance between legs');
INSERT INTO `training_mistake` (id, description, solution) VALUES (2, 'too narrow stance', 'make wider stance');
INSERT INTO `training_mistake` (id, description, solution) VALUES (3, 'too stiff movement', 'relax body');
INSERT INTO `training_mistake` (id, description, solution) VALUES (4, 'too much racket angle', 'decrease racket angle');
INSERT INTO `training_mistake` (id, description, solution) VALUES (5, 'too slow movement', 'make movement faster');
INSERT INTO `training_mistake` (id, description, solution) VALUES (6, 'too strong grip', 'relax hand');

-- vezbe na terninzima
INSERT INTO `training_drill` (id, description, repetitons) VALUES (1, 'from right corner of table', 10);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (2, 'from center position on table', 15);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (3, 'from left corner of table', 5);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (4, 'from left corner of table and center of table', 5);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (5, 'from left corner of table and right corner of table', 5);
INSERT INTO `training_drill` (id, description, repetitons) VALUES (6, 'from centar of table and right corner of table', 7);


-- treninzi pocetnicke tezine pocetnickih tehnika
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (1,'BEGINNER', 8, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (2,'BEGINNER', 7, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (3,'BEGINNER', 6, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (4,'BEGINNER', 5, 2);

-- treninzi srednje tezine pocetnickih tehnika
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (21,'INTERMEDIATE', 8, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (22,'INTERMEDIATE', 8, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (23,'INTERMEDIATE', 7, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (24,'INTERMEDIATE', 6, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (25,'INTERMEDIATE', 5, 2);

-- treninzi srednje tezine tehinka srednjeg nivoa
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (26,'INTERMEDIATE', 1, 2);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (27,'INTERMEDIATE', 2, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (28,'INTERMEDIATE', 1, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (29,'INTERMEDIATE', 2, 4);

-- treninzi napredne tezine tehnika srednjeg nivao
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (30,'ADVANCED', 1, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (31,'ADVANCED', 2, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (32,'ADVANCED', 1, 5);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (33,'ADVANCED', 2, 4);

-- treninzi napredne tezine naprednih tehnika
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (5,'ADVANCED', 3, 3);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (6,'ADVANCED', 4, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (7,'ADVANCED', 3, 5);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (9,'ADVANCED', 4, 4);
INSERT INTO `training` (id, training_level, skill_id, time_to_execute) VALUES (10,'ADVANCED', 4, 6);


-- povezivanje treninga i gresaka pri treningu
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (1,1)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (1,2)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (2,1)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (2,3)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (3,4)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (3,5)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (4,1)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (4,3)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (5,1)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (5,5)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (6,4)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (6,5)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (7,2)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (7,5)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (8,2)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (8,6)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (9,1)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (9,2)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (10, 2)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (10, 6)

INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (21,4)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (21,5)
INSERT INTO `training_mistake_join` (training_id, mistake_id)  VALUES (21,1)


-- povezivanje treninga i vezbi za trening
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (1,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (1,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (1,3)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (2,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (2,4)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (2,5)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (3,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (3,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (3,3)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (4,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (4,5)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (4,4)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (5,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (5,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (5,6)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (6,6)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (6,5)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (6,3)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (7,3)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (7,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (7,5)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (8,4)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (8,3)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (8,2)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (9,6)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (9,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (9,3)

INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (10,1)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (10,2)
INSERT INTO `training_drill_join` (training_id, drill_id)  VALUES (10,3)





-- dosadasnji treninzi korisnika`
INSERT INTO `training_execution` (id , user_id, training_id, date, training_mark) VALUES (2, 1, 9, '2020-07-02', 'EXCELLENT');
INSERT INTO `training_execution` (id , user_id, training_id, date, training_mark) VALUES (1, 1, 2, '2020-07-03', 'EXCELLENT');