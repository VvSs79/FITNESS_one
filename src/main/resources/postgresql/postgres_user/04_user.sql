CREATE TABLE IF NOT EXISTS fitness."user"
(
    uuid uuid NOT NULL,
    dt_created timestamp with time zone,
    dt_update timestamp with time zone,
    fio character varying(255) COLLATE pg_catalog."default",
    mail character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness."user"
    OWNER to postgres;