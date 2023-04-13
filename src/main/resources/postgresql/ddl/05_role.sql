CREATE TABLE IF NOT EXISTS fitness.role
(
    id smallint NOT NULL,
    role character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (id)
)