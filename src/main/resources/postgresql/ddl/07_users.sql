CREATE TABLE IF NOT EXISTS fitness.users
(
    uuid uuid NOT NULL,
    mail character varying COLLATE pg_catalog."default" NOT NULL,
    fio character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    role smallint,
    status smallint,
    CONSTRAINT user_pkey PRIMARY KEY (uuid),
    CONSTRAINT users_role_fkey FOREIGN KEY (role)
        REFERENCES fitness.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT users_status_fkey FOREIGN KEY (status)
        REFERENCES fitness.status (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)