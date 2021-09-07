--
-- PostgreSQL database dump
--

-- Dumped from database version 10.16
-- Dumped by pg_dump version 10.16

-- Started on 2021-09-07 11:32:00

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 206 (class 1259 OID 24645)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    id integer NOT NULL,
    user_id integer NOT NULL,
    film_id integer NOT NULL,
    rate double precision NOT NULL,
    text character varying(255)
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24643)
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_seq OWNER TO postgres;

--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 205
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;


--
-- TOC entry 208 (class 1259 OID 24653)
-- Name: favourite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favourite (
    id integer NOT NULL,
    user_id integer NOT NULL,
    film_id integer NOT NULL
);


ALTER TABLE public.favourite OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24651)
-- Name: favourite_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.favourite_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.favourite_id_seq OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 207
-- Name: favourite_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.favourite_id_seq OWNED BY public.favourite.id;


--
-- TOC entry 199 (class 1259 OID 24606)
-- Name: film; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.film (
    id integer NOT NULL,
    type integer NOT NULL,
    title character varying(30) NOT NULL,
    length time without time zone NOT NULL,
    pegi integer NOT NULL,
    release date NOT NULL,
    user_rate double precision,
    img character varying(255),
    trailer character varying(255) NOT NULL,
    description character varying(255)
);


ALTER TABLE public.film OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24604)
-- Name: film_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.film_id_seq OWNER TO postgres;

--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 198
-- Name: film_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.film_id_seq OWNED BY public.film.id;


--
-- TOC entry 203 (class 1259 OID 24632)
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person (
    id integer NOT NULL,
    role_id integer NOT NULL,
    name character varying(30) NOT NULL,
    surname character varying(30) NOT NULL,
    age integer NOT NULL,
    height integer NOT NULL,
    born date NOT NULL,
    death date,
    img character varying(255) NOT NULL
);


ALTER TABLE public.person OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24630)
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.person_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_id_seq OWNER TO postgres;

--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 202
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.person_id_seq OWNED BY public.person.id;


--
-- TOC entry 204 (class 1259 OID 24638)
-- Name: person_to_film; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person_to_film (
    person_id integer NOT NULL,
    film_id integer NOT NULL
);


ALTER TABLE public.person_to_film OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24619)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id integer NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24617)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 214 (class 1259 OID 24679)
-- Name: type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type (
    id integer NOT NULL,
    type character varying(30) NOT NULL
);


ALTER TABLE public.type OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24677)
-- Name: type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_id_seq OWNER TO postgres;

--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 213
-- Name: type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_id_seq OWNED BY public.type.id;


--
-- TOC entry 197 (class 1259 OID 24589)
-- Name: user_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_table (
    id integer NOT NULL,
    login character varying(20) NOT NULL,
    email character varying(30) NOT NULL,
    password character varying NOT NULL,
    role integer NOT NULL
);


ALTER TABLE public.user_table OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24587)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public.user_table.id;


--
-- TOC entry 212 (class 1259 OID 24669)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    id integer NOT NULL,
    role character varying(20) NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24667)
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_id_seq OWNER TO postgres;

--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_role_id_seq OWNED BY public.user_role.id;


--
-- TOC entry 210 (class 1259 OID 24661)
-- Name: watch_later; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.watch_later (
    id integer NOT NULL,
    user_id integer NOT NULL,
    film_id integer NOT NULL
);


ALTER TABLE public.watch_later OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24659)
-- Name: watch_later_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.watch_later_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.watch_later_id_seq OWNER TO postgres;

--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 209
-- Name: watch_later_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.watch_later_id_seq OWNED BY public.watch_later.id;


--
-- TOC entry 2729 (class 2604 OID 24648)
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_id_seq'::regclass);


--
-- TOC entry 2730 (class 2604 OID 24656)
-- Name: favourite id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourite ALTER COLUMN id SET DEFAULT nextval('public.favourite_id_seq'::regclass);


--
-- TOC entry 2726 (class 2604 OID 24609)
-- Name: film id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film ALTER COLUMN id SET DEFAULT nextval('public.film_id_seq'::regclass);


--
-- TOC entry 2728 (class 2604 OID 24635)
-- Name: person id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person ALTER COLUMN id SET DEFAULT nextval('public.person_id_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 24622)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2733 (class 2604 OID 24682)
-- Name: type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type ALTER COLUMN id SET DEFAULT nextval('public.type_id_seq'::regclass);


--
-- TOC entry 2732 (class 2604 OID 24672)
-- Name: user_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role ALTER COLUMN id SET DEFAULT nextval('public.user_role_id_seq'::regclass);


--
-- TOC entry 2725 (class 2604 OID 24592)
-- Name: user_table id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 24664)
-- Name: watch_later id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watch_later ALTER COLUMN id SET DEFAULT nextval('public.watch_later_id_seq'::regclass);


--
-- TOC entry 2755 (class 2606 OID 24650)
-- Name: comment comment_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pk PRIMARY KEY (id);


--
-- TOC entry 2757 (class 2606 OID 24658)
-- Name: favourite favourite_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourite
    ADD CONSTRAINT favourite_pk PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 24614)
-- Name: film film_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pk PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 24616)
-- Name: film film_title_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_title_key UNIQUE (title);


--
-- TOC entry 2751 (class 2606 OID 24637)
-- Name: person person_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pk PRIMARY KEY (id);


--
-- TOC entry 2753 (class 2606 OID 24642)
-- Name: person_to_film person_to_film_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person_to_film
    ADD CONSTRAINT person_to_film_pk PRIMARY KEY (person_id, film_id);


--
-- TOC entry 2747 (class 2606 OID 24627)
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- TOC entry 2749 (class 2606 OID 24629)
-- Name: role role_role_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_role_key UNIQUE (role);


--
-- TOC entry 2765 (class 2606 OID 24684)
-- Name: type type_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pk PRIMARY KEY (id);


--
-- TOC entry 2767 (class 2606 OID 24686)
-- Name: type type_type_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_type_key UNIQUE (type);


--
-- TOC entry 2735 (class 2606 OID 40985)
-- Name: user_table user_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 2737 (class 2606 OID 24599)
-- Name: user_table user_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_login_key UNIQUE (login);


--
-- TOC entry 2739 (class 2606 OID 40983)
-- Name: user_table user_password_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_password_key UNIQUE (password);


--
-- TOC entry 2741 (class 2606 OID 24597)
-- Name: user_table user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2761 (class 2606 OID 24674)
-- Name: user_role user_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pk PRIMARY KEY (id);


--
-- TOC entry 2763 (class 2606 OID 24676)
-- Name: user_role user_role_role_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_role_key UNIQUE (role);


--
-- TOC entry 2759 (class 2606 OID 24666)
-- Name: watch_later watch_later_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watch_later
    ADD CONSTRAINT watch_later_pk PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 24712)
-- Name: comment comment_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_fk0 FOREIGN KEY (user_id) REFERENCES public.user_table(id);


--
-- TOC entry 2774 (class 2606 OID 24717)
-- Name: comment comment_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_fk1 FOREIGN KEY (film_id) REFERENCES public.film(id);


--
-- TOC entry 2775 (class 2606 OID 24722)
-- Name: favourite favourite_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourite
    ADD CONSTRAINT favourite_fk0 FOREIGN KEY (user_id) REFERENCES public.user_table(id);


--
-- TOC entry 2776 (class 2606 OID 24727)
-- Name: favourite favourite_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourite
    ADD CONSTRAINT favourite_fk1 FOREIGN KEY (film_id) REFERENCES public.film(id);


--
-- TOC entry 2769 (class 2606 OID 24692)
-- Name: film film_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_fk0 FOREIGN KEY (type) REFERENCES public.type(id);


--
-- TOC entry 2770 (class 2606 OID 24697)
-- Name: person person_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_fk0 FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2771 (class 2606 OID 24702)
-- Name: person_to_film person_to_film_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person_to_film
    ADD CONSTRAINT person_to_film_fk0 FOREIGN KEY (person_id) REFERENCES public.person(id);


--
-- TOC entry 2772 (class 2606 OID 24707)
-- Name: person_to_film person_to_film_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person_to_film
    ADD CONSTRAINT person_to_film_fk1 FOREIGN KEY (film_id) REFERENCES public.film(id);


--
-- TOC entry 2768 (class 2606 OID 24687)
-- Name: user_table user_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_fk0 FOREIGN KEY (role) REFERENCES public.user_role(id);


--
-- TOC entry 2777 (class 2606 OID 24732)
-- Name: watch_later watch_later_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watch_later
    ADD CONSTRAINT watch_later_fk0 FOREIGN KEY (user_id) REFERENCES public.user_table(id);


--
-- TOC entry 2778 (class 2606 OID 24737)
-- Name: watch_later watch_later_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watch_later
    ADD CONSTRAINT watch_later_fk1 FOREIGN KEY (film_id) REFERENCES public.film(id);


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2021-09-07 11:32:00

--
-- PostgreSQL database dump complete
--

