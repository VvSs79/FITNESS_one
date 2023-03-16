
CREATE TABLE IF NOT EXISTS fitness.user_role
(
    role_id character varying COLLATE pg_catalog."default" NOT NULL,
    user_uuid uuid NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (user_uuid),
    CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES fitness.role (role) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_role_user_uuid_fkey FOREIGN KEY (user_uuid)
        REFERENCES fitness."user" (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.user_role
    OWNER to postgres;