CREATE TABLE IF NOT EXISTS fitness.role
(
    role character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (role)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.role
    OWNER to postgres;