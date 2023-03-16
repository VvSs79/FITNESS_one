
CREATE TABLE IF NOT EXISTS fitness.ingridient
(
    recipe_id uuid NOT NULL,
    product_id uuid NOT NULL,
    weight integer,
    CONSTRAINT ingridient_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES fitness.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT ingridient_recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES fitness.recipe (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS fitness.ingridient
    OWNER to postgres;