CREATE TABLE comment (
                                id integer IDENTITY NOT NULL PRIMARY KEY,
                                user_id integer NOT NULL,
                                film_id integer NOT NULL,
                                rate double precision NOT NULL,
                                text varchar(255)
);

CREATE TABLE favourite (
                                  id integer IDENTITY NOT NULL PRIMARY KEY,
                                  user_id integer NOT NULL,
                                  film_id integer NOT NULL
);

CREATE TABLE film (
                             id integer IDENTITY NOT NULL PRIMARY KEY,
                             type integer NOT NULL,
                             title varchar(30) NOT NULL,
                             length time NOT NULL,
                             pegi integer NOT NULL,
                             release date NOT NULL,
                             user_rate double precision,
                             img varchar(255),
                             trailer varchar(255) NOT NULL,
                             description varchar(255)
);

CREATE TABLE person (
                               id integer IDENTITY NOT NULL PRIMARY KEY,
                               role_id integer NOT NULL,
                               name varchar(30) NOT NULL,
                               surname varchar(30) NOT NULL,
                               age integer NOT NULL,
                               height integer NOT NULL,
                               born date NOT NULL,
                               death date,
                               img varchar(255) NOT NULL
);

CREATE TABLE person_to_film (
                                       id integer IDENTITY NOT NULL PRIMARY KEY,
                                       person_id integer NOT NULL,
                                       film_id integer NOT NULL
);

CREATE TABLE role (
                             id integer IDENTITY NOT NULL PRIMARY KEY,
                             role varchar(15) NOT NULL
);

CREATE TABLE type (
                             id integer IDENTITY NOT NULL PRIMARY KEY,
                             type varchar(30) NOT NULL
);

CREATE TABLE user_table (
                                   id integer IDENTITY NOT NULL PRIMARY KEY,
                                   login varchar(20) NOT NULL,
                                   email varchar(30) NOT NULL,
                                   password varchar(255) NOT NULL,
                                   role integer NOT NULL
);

CREATE TABLE user_role (
                                  id integer IDENTITY NOT NULL PRIMARY KEY,
                                  role varchar(10) NOT NULL
);

CREATE TABLE watch_later (
                                    id integer IDENTITY NOT NULL PRIMARY KEY,
                                    user_id integer NOT NULL,
                                    film_id integer NOT NULL
);

ALTER TABLE film
    ADD CONSTRAINT film_title_key UNIQUE (title);
ALTER TABLE role
    ADD CONSTRAINT role_role_key UNIQUE (role);
ALTER TABLE type
    ADD CONSTRAINT type_type_key UNIQUE (type);
ALTER TABLE user_table
    ADD CONSTRAINT user_email_key UNIQUE (email);
ALTER TABLE user_table
    ADD CONSTRAINT user_login_key UNIQUE (login);
ALTER TABLE user_table
    ADD CONSTRAINT user_password_key UNIQUE (password);
ALTER TABLE user_role
    ADD CONSTRAINT user_role_role_key UNIQUE (role);
ALTER TABLE comment
    ADD CONSTRAINT comment_fk0 FOREIGN KEY (user_id) REFERENCES user_table(id);
ALTER TABLE comment
    ADD CONSTRAINT comment_fk1 FOREIGN KEY (film_id) REFERENCES film(id);
ALTER TABLE favourite
    ADD CONSTRAINT favourite_fk0 FOREIGN KEY (user_id) REFERENCES user_table(id);
ALTER TABLE favourite
    ADD CONSTRAINT favourite_fk1 FOREIGN KEY (film_id) REFERENCES film(id);
ALTER TABLE film
    ADD CONSTRAINT film_fk0 FOREIGN KEY (type) REFERENCES type(id);
ALTER TABLE person
    ADD CONSTRAINT person_fk0 FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE person_to_film
    ADD CONSTRAINT person_to_film_fk0 FOREIGN KEY (person_id) REFERENCES person(id);
ALTER TABLE person_to_film
    ADD CONSTRAINT person_to_film_fk1 FOREIGN KEY (film_id) REFERENCES film(id);
ALTER TABLE user_table
    ADD CONSTRAINT user_fk0 FOREIGN KEY (role) REFERENCES user_role(id);
ALTER TABLE watch_later
    ADD CONSTRAINT watch_later_fk0 FOREIGN KEY (user_id) REFERENCES user_table(id);
ALTER TABLE watch_later
    ADD CONSTRAINT watch_later_fk1 FOREIGN KEY (film_id) REFERENCES film(id);

INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (3, 1, 6, 5.5, 'Very funny film, great job !');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (4, 2, 6, 7.5, 'WOW, nice movie');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (5, 3, 6, 2, 'Bad as always');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (6, 4, 6, 10, 'Funny #@!');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (31, 1, 6, 8, 'fajny film polecam');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (32, 1, 7, 8, 'hahahahaha');
INSERT INTO comment (id, user_id, film_id, rate, text) VALUES (33, 1, 8, 9.9000000000000004, 'very good');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (7, 13, 'Tomb raider', '01:55:00', 12, '2018-03-02', 4.7999999999999998, 'https://fwcdn.pl/fpo/74/79/557479/7821525.6.jpg', 'https://www.youtube.com/watch?v=8ndhidEmUbI', 'Lara Croft (Alicia Vikander), the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she discovers the island where her father, Lord Richard Croft (Dominic West) disappeared.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (8, 1, 'Black widow', '01:43:00', 12, '2021-07-09', 6.2000000000000002, 'https://fwcdn.pl/fpo/09/86/120986/7964716.6.jpg', 'https://www.youtube.com/watch?v=Fp9pNPdNwjI', 'Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (9, 8, 'Joker', '01:45:00', 18, '2019-08-31', 7.0999999999999996, 'https://fwcdn.pl/fpo/01/67/810167/7898604.6.jpg', 'https://www.youtube.com/watch?v=zAGVQLHvwOY', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (10, 2, 'Bumblebee', '01:54:00', 12, '2018-12-03', 6.7000000000000002, 'https://fwcdn.pl/fpo/03/50/790350/7875483.6.jpg', 'https://www.youtube.com/watch?v=lcwmDAYt22k', 'On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small California beach town. On the cusp of turning 18 and trying to find her place in the world, Charlie Watson discovers Bumblebee, battle-scarred and broken.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (1, 1, 'The Fate of the Furious', '02:16:00', 12, '2017-04-21', 6.5999999999999996, 'https://fwcdn.pl/fpo/19/81/741981/7783412.3.jpg', 'https://www.youtube.com/watch?v=8GVFHpf5EYU', 'When a mysterious woman seduces Dominic Toretto into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (4, 12, 'The Conjuring', '01:52:00', 18, '2013-07-26', 7.5, 'https://fwcdn.pl/fpo/71/00/627100/7557683.3.jpg', 'https://www.youtube.com/watch?v=yOOdDin4OCA', 'Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (5, 7, 'Free Guy', '01:55:00', 12, '2021-08-13', 7.5999999999999996, 'https://fwcdn.pl/fpo/82/06/828206/7962939.6.jpg', 'https://www.youtube.com/watch?v=9NTyw_OMD0Q', 'A bank teller discovers that he''s actually an NPC inside a brutal, open world video game.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (2, 7, 'Killer', '01:44:00', 12, '1997-11-17', 10, 'https://i0.wp.com/easterneuropeanmovies.com/wp-content/uploads/47.jpg?fit=560%2C786&ssl=1', 'https://www.youtube.com/watch?v=0QsgQgT0O5E', 'Jerzy Kiler, warszawski taksówkarz, przypadkowo zostaje wzięty za płatnego zabójcę i umieszczony w areszcie. Wyciąga go stamtąd boss świata przestępczego, który oferuje mu nowe zadanie.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (3, 2, 'Avatar', '02:42:00', 12, '2009-12-10', 7.7999999999999998, 'https://fwcdn.pl/fpo/91/13/299113/7332755.3.jpg', 'https://www.youtube.com/watch?v=5PSNL1qE6VY', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.');
INSERT INTO film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (6, 13, 'JUMANJI: Next level', '01:33:00', 6, '2019-12-04', 6, 'https://fwcdn.pl/fpo/49/57/834957/7911699.6.jpg', 'https://www.youtube.com/watch?v=2QKg5SZ_35I', 'In Jumanji: The Next Level, the gang is back but the game has changed. As they return to rescue one of their own, the players will have to brave parts unknown from arid deserts to snowy mountains, to escape the worlds most dangerous game.');
INSERT INTO role (id, role) VALUES (1, 'Director');
INSERT INTO role (id, role) VALUES (2, 'Actor');
INSERT INTO role (id, role) VALUES (3, 'Writer');
INSERT INTO type (id, type) VALUES (2, 'Sci-fi');
INSERT INTO type (id, type) VALUES (3, 'Thriller');
INSERT INTO type (id, type) VALUES (10, 'Western');
INSERT INTO type (id, type) VALUES (12, 'Horror');
INSERT INTO type (id, type) VALUES (1, 'Action');
INSERT INTO type (id, type) VALUES (4, 'Animated');
INSERT INTO type (id, type) VALUES (5, 'Document');
INSERT INTO type (id, type) VALUES (6, 'History');
INSERT INTO type (id, type) VALUES (7, 'Comedy');
INSERT INTO type (id, type) VALUES (8, 'Crime');
INSERT INTO type (id, type) VALUES (9, 'Religious');
INSERT INTO type (id, type) VALUES (13, 'Adventure');
INSERT INTO user_role (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO user_role (id, role) VALUES (2, 'ROLE_ADMIN');
INSERT INTO user_table (id, login, email, password, role) VALUES (1, 'Goldi', 'goldi@gmail.com', 'haslo1', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (2, 'Kacper', 'kacper55@gmail.com', 'testPassword', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (3, 'Patryk', 'patrykinny@gmail.com', 'testPassword2', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (4, 'admin', 'admin@gmail.com', 'testAdmin1234', 2);
INSERT INTO user_table (id, login, email, password, role) VALUES (5, 'Kuba', 'kubaS@gmail.com', 'testPass1234', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (6, 'Maciek', 'trollek@gmail.com', 'testPass12345', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (7, 'Stefan', 'stefanek@gmail.com', '12345', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (8, 'test', 'test@gmail.com', 'test12345', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (11, 'test1', 'test1@gmail.com', 'test1', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (13, 'test2', 'test2@gmail.com', 'test2', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (16, 'test4', 'test4@gmail.com', 'test4', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (17, 'Kacperowski', 'test2145@gmail.com', 'abcd12347890', 1);
INSERT INTO user_table (id, login, email, password, role) VALUES (18, 'Kacper Kluska', 'kacperkluska27@wp.pl', 'abcd', 1);