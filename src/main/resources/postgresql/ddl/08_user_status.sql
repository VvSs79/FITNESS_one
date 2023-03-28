CREATE TABLE IF NOT EXISTS fitness.user_status
(
    uuid_user uuid NOT NULL,
    status_user character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_status_status_user_fkey FOREIGN KEY (status_user)
        REFERENCES fitness.status (status) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_status_uuid_user_fkey FOREIGN KEY (uuid_user)
        REFERENCES fitness.users (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

