-- Table: orderr

-- DROP TABLE public.orderr;

CREATE TABLE public.orderr
(
  id serial NOT NULL,
  date date NOT NULL,
  customer_name character varying(50) NOT NULL,
  CONSTRAINT order_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.orderr
  OWNER TO postgres;

-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
  id serial NOT NULL,
  name character varying(50) NOT NULL,
  CONSTRAINT product_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO postgres;

-- Table: public.order_detail

-- DROP TABLE public.order_detail;

CREATE TABLE public.order_detail
(
  product_id integer NOT NULL,
  order_id integer NOT NULL,
  CONSTRAINT order_detail_pkey PRIMARY KEY (product_id, order_id),
  CONSTRAINT order_detail_product_id_fkey FOREIGN KEY (product_id)
      REFERENCES public.product (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT order_detail_order_id_fkey FOREIGN KEY (order_id)
      REFERENCES public.orderr (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.order_detail
  OWNER TO postgres;