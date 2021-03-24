drop table state;
drop table country;
drop table order_item;
drop table orders;
drop table address;
drop table customer;
drop table product;
drop table product_category;

create table product_category (
  category_id  integer not null GENERATED ALWAYS AS IDENTITY primary key,
  category_name varchar(150)
);

create table product(
  product_id integer NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  sku VARCHAR(100) DEFAULT NULL,
  name VARCHAR(120) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  active smallint DEFAULT 1,
  units_in_stock integer DEFAULT NULL,
  date_created date DEFAULT NULL,
  last_updated date DEFAULT NULL,
  category_id integer NOT NULL,
  CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (category_id)
);

CREATE TABLE country (
  country_id integer  NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  code varchar(2) DEFAULT NULL,
  name varchar(255) DEFAULT NULL
);

CREATE TABLE state (
  state_id integer NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  name varchar(255) DEFAULT NULL,
  country_id integer  NOT NULL,  
  CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (country_id)
);

CREATE TABLE address (
  address_id integer NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  city varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  zip_code varchar(255) DEFAULT NULL
);

CREATE TABLE customer (
  customer_id integer NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  email varchar(255) unique DEFAULT NULL
);


CREATE TABLE orders (
  order_id integer GENERATED ALWAYS AS IDENTITY primary key,
  order_tracking_number varchar(255) DEFAULT NULL,
  total_price decimal(19,2) DEFAULT NULL,
  total_quantity integer DEFAULT NULL,
  billing_address_id integer DEFAULT NULL,
  customer_id integer DEFAULT NULL,
  shipping_address_id integer DEFAULT NULL,
  status varchar(128) DEFAULT NULL,
  date_created date DEFAULT NULL,
  last_updated date DEFAULT NULL,
  CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT FK_billing_address_id FOREIGN KEY (billing_address_id) REFERENCES address (address_id),
  CONSTRAINT FK_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES address (address_id)
);

create unique index UK_billing_address_id on orders (billing_address_id);
create unique index UK_shipping_address_id on orders (shipping_address_id);

CREATE TABLE order_item (
  order_item_id integer NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
  image_url varchar(255) DEFAULT NULL,
  quantity integer DEFAULT NULL,
  unit_price decimal(19,2) DEFAULT NULL,
  order_id integer DEFAULT NULL,
  product_id integer DEFAULT NULL,
  CONSTRAINT FK_order_id FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT FK_product_id FOREIGN KEY (product_id) REFERENCES product (product_id)
);