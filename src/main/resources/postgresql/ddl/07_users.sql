CREATE TABLE IF NOT EXISTS fitness.users
(
    uuid uuid NOT NULL,
    mail character varying COLLATE pg_catalog."default" NOT NULL,
    fio character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (uuid)
)