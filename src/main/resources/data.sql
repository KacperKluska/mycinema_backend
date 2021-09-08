INSERT INTO user_role (id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_role (id, role)
VALUES (2, 'ROLE_USER');
INSERT INTO user_table (id, login, email, password)
VALUES (1, 'Admin', 'admin@test.com', '$2a$10$sec0QlUD1DEvoavWWVQru.potyOVcpsZKe5uhCkz533q2hnWrW.2i'); --password1234
INSERT INTO user_table (id, login, email, password)
VALUES (2, 'User', 'user@test.com', '$2a$10$UDrNkLL5J6P.6B7MHklxK.79N0akk3EJbKixIWIZ2U7ms2ICyoDWe'); --1234password
INSERT INTO user_to_user_role(user_id, user_role_id)
VALUES (1, 1);
INSERT INTO user_to_user_role(user_id, user_role_id)
VALUES (1, 2);
INSERT INTO user_to_user_role(user_id, user_role_id)
VALUES (2, 2);