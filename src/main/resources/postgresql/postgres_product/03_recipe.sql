CREATE TABLE IF NOT EXISTS fitness.recipe
(
    uuid uuid NOT NULL,
    dt_created timestamp with time zone NOT NULL,
    dt_update timestamp with time zone NOT NULL,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT recipe_pkey PRIMARY KEY (uuid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.recipe
    OWNER to postgres;