CREATE TABLE role
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    role VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE role
    ADD CONSTRAINT uc_role_role UNIQUE (role);

CREATE TABLE type
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type VARCHAR(255),
    CONSTRAINT pk_type PRIMARY KEY (id)
);

ALTER TABLE type
    ADD CONSTRAINT uc_type_type UNIQUE (type);

CREATE TABLE user_table
(
    id       INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login    VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user_table
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user_table
    ADD CONSTRAINT uc_user_login UNIQUE (login);

CREATE TABLE user_role
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    role VARCHAR(255),
    CONSTRAINT pk_user_role PRIMARY KEY (id)
);

CREATE TABLE user_to_user_role
(
    user_id INTEGER NOT NULL,
    user_role_id   INTEGER NOT NULL,
    CONSTRAINT pk_user_to_user_role PRIMARY KEY (user_id, user_role_id)
);

ALTER TABLE user_to_user_role
    ADD CONSTRAINT FK_USER_TO_USER_ROLE_ON_USER FOREIGN KEY (user_id) REFERENCES user_table (id);

ALTER TABLE user_to_user_role
    ADD CONSTRAINT FK_USER_TO_USER_ROLE_ON_USER_ROLE FOREIGN KEY (user_role_id) REFERENCES user_role (id);

CREATE TABLE film
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title       VARCHAR(255),
    length      TIME,
    pegi        INTEGER,
    release     date,
    user_rate   DOUBLE PRECISION,
    img         VARCHAR(255),
    trailer     VARCHAR(255),
    type_id     INTEGER,
    description VARCHAR(255),
    CONSTRAINT pk_film PRIMARY KEY (id)
);

ALTER TABLE film
    ADD CONSTRAINT FK_FILM_ON_TYPE FOREIGN KEY (type_id) REFERENCES type (id);

CREATE TABLE comment
(
    id      INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    rate    DOUBLE PRECISION,
    text    VARCHAR(255),
    user_id INTEGER,
    film_id INTEGER,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_FILM FOREIGN KEY (film_id) REFERENCES film (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_USER FOREIGN KEY (user_id) REFERENCES user_table (id);

CREATE TABLE favourite
(
    id      INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_id INTEGER,
    film_id INTEGER,
    CONSTRAINT pk_favourite PRIMARY KEY (id)
);

ALTER TABLE favourite
    ADD CONSTRAINT FK_FAVOURITE_ON_FILM FOREIGN KEY (film_id) REFERENCES film (id);

ALTER TABLE favourite
    ADD CONSTRAINT FK_FAVOURITE_ON_USER FOREIGN KEY (user_id) REFERENCES user_table (id);

CREATE TABLE person
(
    id      INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR(255),
    surname VARCHAR(255),
    age     INTEGER,
    height  INTEGER,
    born    date,
    death   date,
    img     VARCHAR(255),
    role_id INTEGER,
    CONSTRAINT pk_person PRIMARY KEY (id)
);

ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_ROLE FOREIGN KEY (role_id) REFERENCES role (id);

CREATE TABLE person_to_film
(
    person_id INTEGER NOT NULL,
    film_id   INTEGER NOT NULL,
    CONSTRAINT pk_person_to_film PRIMARY KEY (person_id, film_id)
);

ALTER TABLE person_to_film
    ADD CONSTRAINT FK_PERSON_TO_FILM_ON_FILM FOREIGN KEY (film_id) REFERENCES film (id);

ALTER TABLE person_to_film
    ADD CONSTRAINT FK_PERSON_TO_FILM_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

CREATE TABLE watch_later
(
    id      INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_id INTEGER,
    film_id INTEGER,
    CONSTRAINT pk_watch_later PRIMARY KEY (id)
);

ALTER TABLE watch_later
    ADD CONSTRAINT FK_WATCH_LATER_ON_FILM FOREIGN KEY (film_id) REFERENCES film (id);

ALTER TABLE watch_later
    ADD CONSTRAINT FK_WATCH_LATER_ON_USER FOREIGN KEY (user_id) REFERENCES user_table (id);