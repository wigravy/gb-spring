

    -- !    скрипт создания таблиц  ! --

CREATE TABLE products.product
(
    id bigint NOT NULL DEFAULT nextval('products.product_id_seq'::regclass),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    cost numeric NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
)


CREATE INDEX product_name
    ON products.product USING btree
    (title COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;

    -- !  Тестовые данные  ! --

insert into products.product (title, cost) values
('pear', 1.85),
('melon', 3.70),
('cherry', 5.00),
('peach', 2.77),
('apricot', 2.20),
('shrimp', 12.00),
('bagel', 0.50),
('potatoes', 6.00),
('chocolate', 10.25),
('corn', 0.70),
('gum', 1.40),
('soda', 3.99),
('milk', 1.85),
('apple', 3.70),
('orange', 5.00),
('coconut', 6.79),
('meat', 9.40),
('rice', 2.60),
('nuts', 6.50),
('perch', 6.00);