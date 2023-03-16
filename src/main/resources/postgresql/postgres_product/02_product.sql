
CREATE TABLE IF NOT EXISTS fitness.product
(
    id uuid NOT NULL,
    dt_created timestamp with time zone NOT NULL,
    dp_update timestamp with time zone NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    proteinas double precision,
    fats double precision,
    carbohydrates double precision,
    calories integer,
    weight integer,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT product_title_key UNIQUE (title)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.product
    OWNER to postgres;