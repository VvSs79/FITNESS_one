CREATE TABLE IF NOT EXISTS fitness.recipe
(
    uuid uuid NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT recipe_pkey PRIMARY KEY (uuid),
    CONSTRAINT recipe_title_key UNIQUE (title)
)
