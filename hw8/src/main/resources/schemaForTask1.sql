CREATE TABLE customer (
  id UUID NOT NULL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  cell_phone VARCHAR(64) NOT NULL
);

CREATE TABLE product (
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  current_price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE "order" (
  id UUID NOT NULL PRIMARY KEY,
  customer UUID NOT NULL REFERENCES customer(id),
  delivery_place VARCHAR(255) NOT NULL
);

CREATE TABLE product_in_order (
  product UUID NOT NULL REFERENCES product(id),
  "order" UUID NOT NULL REFERENCES "order"(id),
  quantity INTEGER NOT NULL,
  price NUMERIC(10, 2) NOT NULL,
  PRIMARY KEY (product, "order")
);
