CREATE TABLE IF NOT EXISTS fitness.status
(
    id smallint NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT status_pkey PRIMARY KEY (id)
)