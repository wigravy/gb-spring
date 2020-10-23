-- скрипт создания таблиц

CREATE TABLE products.orders
(
    id bigint NOT NULL DEFAULT nextval('products.order_id_seq'::regclass),
    customer_id bigint NOT NULL,
    order_date timestamp with time zone NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (id),
    CONSTRAINT customer_id_fk FOREIGN KEY (customer_id)
        REFERENCES products.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE products.product
(
    id bigint NOT NULL DEFAULT nextval('products.product_id_seq'::regclass),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    cost numeric NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
)

CREATE TABLE products.order_item
(
    id bigint NOT NULL DEFAULT nextval('products.order_item_id_seq'::regclass),
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    cost numeric NOT NULL,
    CONSTRAINT order_item_pkey PRIMARY KEY (id),
    CONSTRAINT order_id_fk FOREIGN KEY (order_id)
        REFERENCES products.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT product_id_fk FOREIGN KEY (product_id)
        REFERENCES products.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE products.customer
(
    id bigint NOT NULL DEFAULT nextval('products.customer_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)