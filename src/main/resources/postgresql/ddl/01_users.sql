\c usersDB

CREATE SCHEMA IF NOT EXISTS public
    AUTHORIZATION "user";

CREATE TABLE IF NOT EXISTS public.users
(
    uuid uuid NOT NULL,
    dt_create timestamp(3) without time zone NOT NULL,
    dt_update timestamp(3) without time zone NOT NULL,
    fio character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role smallint,
    status smallint,
    CONSTRAINT users_pkey PRIMARY KEY (uuid),
    CONSTRAINT mail_unique UNIQUE (mail)
);

