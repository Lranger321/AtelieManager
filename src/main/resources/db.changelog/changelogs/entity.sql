--liquibase formatted sql

--changeset nkozlov:entities
CREATE TABLE client
(
    id     bigint      not null primary key,
    name   varchar(45) not null,
    email  varchar(45) not null,
    number varchar(45) not null
);
CREATE TABLE model
(
    id   bigint      not null primary key,
    name varchar(45) not null,
    type varchar(45) not null
);
CREATE TABLE material
(
    id   bigint      not null primary key,
    name varchar(45) not null,
    type varchar(45) not null
);
CREATE TABLE orders
(
    id         bigint      not null primary key,
    client_id  bigint      not null,
    model_id   bigint      not null,
    gender     varchar(10) not null,
    color      varchar(10) not null,
    type       varchar(10) not null,
    created_at timestamp   not null,
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (model_id) REFERENCES model (id)
);
CREATE TABLE parameter
(
    id       bigint        not null primary key,
    name     varchar(45)   not null,
    size     numeric(8, 2) not null,
    order_id bigint        not null,
    FOREIGN KEY (order_id) REFERENCES orders (id)
);
CREATE TABLE attribute
(
    id          bigint      not null primary key,
    name        varchar(45) not null,
    material_id bigint      not null,
    order_id    bigint      not null,
    FOREIGN KEY (material_id) REFERENCES material (id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);
--comment: Добавлены основные талблицы

--changeset nkozlov:sequence
CREATE SEQUENCE client_id_seq;
CREATE SEQUENCE material_id_seq;
CREATE SEQUENCE model_id_seq;
CREATE SEQUENCE order_id_seq;
CREATE SEQUENCE parameter_id_seq;
CREATE SEQUENCE attribute_id_seq;
ALTER TABLE client
    ALTER id SET DEFAULT NEXTVAL('client_id_seq');
ALTER TABLE material
    ALTER id SET DEFAULT NEXTVAL('material_id_seq');
ALTER TABLE model
    ALTER id SET DEFAULT NEXTVAL('model_id_seq');
ALTER TABLE orders
    ALTER id SET DEFAULT NEXTVAL('order_id_seq');
ALTER TABLE parameter
    ALTER id SET DEFAULT NEXTVAL('parameter_id_seq');
ALTER TABLE attribute
    ALTER id SET DEFAULT NEXTVAL('attribute_id_seq');
--comment: Сиквенсы

--changeset nkozlov:status-column
ALTER TABLE orders
    ADD COLUMN status varchar(10) NOT NULL;
--comment: Добавил колонку статуса заказа

--changeset nkozlov:date-column
ALTER TABLE orders
    ALTER COLUMN created_at TYPE timestamp;
--comment: Изменил тип данных у даты
