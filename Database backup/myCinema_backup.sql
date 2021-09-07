--
-- PostgreSQL database dump
--

-- Dumped from database version 10.16
-- Dumped by pg_dump version 10.16

-- Started on 2021-09-07 11:24:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2910 (class 0 OID 24645)
-- Dependencies: 206
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (3, 1, 6, 5.5, 'Very funny film, great job !');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (4, 2, 6, 7.5, 'WOW, nice movie');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (5, 3, 6, 2, 'Bad as always');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (6, 4, 6, 10, 'Funny #@!');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (31, 1, 6, 8, 'fajny film polecam');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (32, 1, 7, 8, 'hahahahaha');
INSERT INTO public.comment (id, user_id, film_id, rate, text) VALUES (33, 1, 8, 9.9000000000000004, 'very good');


--
-- TOC entry 2912 (class 0 OID 24653)
-- Dependencies: 208
-- Data for Name: favourite; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2903 (class 0 OID 24606)
-- Dependencies: 199
-- Data for Name: film; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (7, 13, 'Tomb raider', '01:55:00', 12, '2018-03-02', 4.7999999999999998, 'https://fwcdn.pl/fpo/74/79/557479/7821525.6.jpg', 'https://www.youtube.com/watch?v=8ndhidEmUbI', 'Lara Croft (Alicia Vikander), the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she discovers the island where her father, Lord Richard Croft (Dominic West) disappeared.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (8, 1, 'Black widow', '01:43:00', 12, '2021-07-09', 6.2000000000000002, 'https://fwcdn.pl/fpo/09/86/120986/7964716.6.jpg', 'https://www.youtube.com/watch?v=Fp9pNPdNwjI', 'Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (9, 8, 'Joker', '01:45:00', 18, '2019-08-31', 7.0999999999999996, 'https://fwcdn.pl/fpo/01/67/810167/7898604.6.jpg', 'https://www.youtube.com/watch?v=zAGVQLHvwOY', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (10, 2, 'Bumblebee', '01:54:00', 12, '2018-12-03', 6.7000000000000002, 'https://fwcdn.pl/fpo/03/50/790350/7875483.6.jpg', 'https://www.youtube.com/watch?v=lcwmDAYt22k', 'On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small California beach town. On the cusp of turning 18 and trying to find her place in the world, Charlie Watson discovers Bumblebee, battle-scarred and broken.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (1, 1, 'The Fate of the Furious', '02:16:00', 12, '2017-04-21', 6.5999999999999996, 'https://fwcdn.pl/fpo/19/81/741981/7783412.3.jpg', 'https://www.youtube.com/watch?v=8GVFHpf5EYU', 'When a mysterious woman seduces Dominic Toretto into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (4, 12, 'The Conjuring', '01:52:00', 18, '2013-07-26', 7.5, 'https://fwcdn.pl/fpo/71/00/627100/7557683.3.jpg', 'https://www.youtube.com/watch?v=yOOdDin4OCA', 'Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (5, 7, 'Free Guy', '01:55:00', 12, '2021-08-13', 7.5999999999999996, 'https://fwcdn.pl/fpo/82/06/828206/7962939.6.jpg', 'https://www.youtube.com/watch?v=9NTyw_OMD0Q', 'A bank teller discovers that he''s actually an NPC inside a brutal, open world video game.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (2, 7, 'Killer', '01:44:00', 12, '1997-11-17', 10, 'https://i0.wp.com/easterneuropeanmovies.com/wp-content/uploads/47.jpg?fit=560%2C786&ssl=1', 'https://www.youtube.com/watch?v=0QsgQgT0O5E', 'Jerzy Kiler, warszawski taksówkarz, przypadkowo zostaje wzięty za płatnego zabójcę i umieszczony w areszcie. Wyciąga go stamtąd boss świata przestępczego, który oferuje mu nowe zadanie.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (3, 2, 'Avatar', '02:42:00', 12, '2009-12-10', 7.7999999999999998, 'https://fwcdn.pl/fpo/91/13/299113/7332755.3.jpg', 'https://www.youtube.com/watch?v=5PSNL1qE6VY', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.');
INSERT INTO public.film (id, type, title, length, pegi, release, user_rate, img, trailer, description) VALUES (6, 13, 'JUMANJI: Next level', '01:33:00', 6, '2019-12-04', 6, 'https://fwcdn.pl/fpo/49/57/834957/7911699.6.jpg', 'https://www.youtube.com/watch?v=2QKg5SZ_35I', 'In Jumanji: The Next Level, the gang is back but the game has changed. As they return to rescue one of their own, the players will have to brave parts unknown from arid deserts to snowy mountains, to escape the worlds most dangerous game.');


--
-- TOC entry 2907 (class 0 OID 24632)
-- Dependencies: 203
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2908 (class 0 OID 24638)
-- Dependencies: 204
-- Data for Name: person_to_film; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2905 (class 0 OID 24619)
-- Dependencies: 201
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (id, role) VALUES (1, 'Director');
INSERT INTO public.role (id, role) VALUES (2, 'Actor');
INSERT INTO public.role (id, role) VALUES (3, 'Writer');


--
-- TOC entry 2918 (class 0 OID 24679)
-- Dependencies: 214
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.type (id, type) VALUES (2, 'Sci-fi');
INSERT INTO public.type (id, type) VALUES (3, 'Thriller');
INSERT INTO public.type (id, type) VALUES (10, 'Western');
INSERT INTO public.type (id, type) VALUES (12, 'Horror');
INSERT INTO public.type (id, type) VALUES (1, 'Action');
INSERT INTO public.type (id, type) VALUES (4, 'Animated');
INSERT INTO public.type (id, type) VALUES (5, 'Document');
INSERT INTO public.type (id, type) VALUES (6, 'History');
INSERT INTO public.type (id, type) VALUES (7, 'Comedy');
INSERT INTO public.type (id, type) VALUES (8, 'Crime');
INSERT INTO public.type (id, type) VALUES (9, 'Religious');
INSERT INTO public.type (id, type) VALUES (13, 'Adventure');


--
-- TOC entry 2916 (class 0 OID 24669)
-- Dependencies: 212
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_role (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO public.user_role (id, role) VALUES (2, 'ROLE_ADMIN');


--
-- TOC entry 2901 (class 0 OID 24589)
-- Dependencies: 197
-- Data for Name: user_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_table (id, login, email, password, role) VALUES (1, 'Goldi', 'goldi@gmail.com', 'haslo1', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (2, 'Kacper', 'kacper55@gmail.com', 'testPassword', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (3, 'Patryk', 'patrykinny@gmail.com', 'testPassword2', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (4, 'admin', 'admin@gmail.com', 'testAdmin1234', 2);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (5, 'Kuba', 'kubaS@gmail.com', 'testPass1234', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (6, 'Maciek', 'trollek@gmail.com', 'testPass12345', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (7, 'Stefan', 'stefanek@gmail.com', '12345', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (8, 'test', 'test@gmail.com', 'test12345', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (11, 'test1', 'test1@gmail.com', 'test1', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (13, 'test2', 'test2@gmail.com', 'test2', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (16, 'test4', 'test4@gmail.com', 'test4', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (17, 'Kacperowski', 'test2145@gmail.com', 'abcd12347890', 1);
INSERT INTO public.user_table (id, login, email, password, role) VALUES (18, 'Kacper Kluska', 'kacperkluska27@wp.pl', 'abcd', 1);


--
-- TOC entry 2914 (class 0 OID 24661)
-- Dependencies: 210
-- Data for Name: watch_later; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 205
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comment_id_seq', 33, true);


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 207
-- Name: favourite_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.favourite_id_seq', 3, true);


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 198
-- Name: film_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.film_id_seq', 10, true);


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 202
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.person_id_seq', 1, false);


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 7, true);


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 213
-- Name: type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_id_seq', 13, true);


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 27, true);


--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_role_id_seq', 2, true);


--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 209
-- Name: watch_later_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.watch_later_id_seq', 5, true);


-- Completed on 2021-09-07 11:24:31

--
-- PostgreSQL database dump complete
--

