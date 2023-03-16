CREATE TABLE IF NOT EXISTS fitness.verification
(
    uuid uuid NOT NULL,
    code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT verification_pkey PRIMARY KEY (uuid),
    CONSTRAINT verification_uuid_fkey FOREIGN KEY (uuid)
        REFERENCES fitness."user" (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.verification
    OWNER to postgres;