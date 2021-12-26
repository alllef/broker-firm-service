ALTER TABLE IF EXISTS flat
    DROP CONSTRAINT IF EXISTS fk_client;
ALTER TABLE IF EXISTS flat
    DROP CONSTRAINT IF EXISTS fk_broker;
ALTER TABLE IF EXISTS purchase_agreement
    DROP CONSTRAINT IF EXISTS fk_flat;
ALTER TABLE IF EXISTS agreement_document
    DROP CONSTRAINT IF EXISTS fk_purchase_agreement;
ALTER TABLE IF EXISTS flat_photo
    DROP CONSTRAINT IF EXISTS fk_flat;
ALTER TABLE IF EXISTS agreement_document
    DROP CONSTRAINT IF EXISTS fk_flat_document;

DROP TABLE IF EXISTS broker CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS flat_document CASCADE;
DROP TABLE IF EXISTS flat_photo CASCADE;
DROP TABLE IF EXISTS purchase_agreement CASCADE;
DROP TABLE IF EXISTS agreement_document CASCADE;
DROP TABLE IF EXISTS flat CASCADE;
DROP TABLE IF EXISTS flat_request CASCADE;
CREATE TABLE broker
(
    broker_id    serial        NOT NULL,
    first_name   varchar(1024) NOT NULL,
    last_name    varchar(1024) NOT NULL,
    phone_number varchar(1024) NOT NULL,
    email        varchar(1024) NOT NULL,
    CONSTRAINT broker_pkey PRIMARY KEY (broker_id)
);

CREATE TABLE client
(
    client_id      serial        NOT NULL,
    first_name     varchar(1024) NOT NULL,
    last_name      varchar(1024) NOT NULL,
    email          varchar(1024) NULL,
    phone_number   varchar(1024) NOT NULL,
    client_address text,
    CONSTRAINT client_pkey PRIMARY KEY (client_id)
);

CREATE TABLE flat
(
    flat_id            serial NOT NULL,
    client_id          int8   NOT NULL,
    broker_id          int8   NOT NULL,
    is_broker_accepted boolean DEFAULT FALSE,
    floor_number       int4   NOT NULL,
    total_area         int4   NOT NULL,
    price              int4   NOT NULL,
    rooms_number       int4   NOT NULL,
    description        text   NOT NULL,
    CONSTRAINT flat_pkey PRIMARY KEY (flat_id),
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE CASCADE,
    CONSTRAINT fk_broker FOREIGN KEY (broker_id) REFERENCES broker (broker_id) ON DELETE CASCADE
);

CREATE TABLE flat_photo
(
    flat_photo_id serial NOT NULL,
    flat_id       int8   NOT NULL,
    photo_url     text   NOT NULL,
    CONSTRAINT flat_photo_pkey PRIMARY KEY (flat_photo_id),
    CONSTRAINT fk_flat FOREIGN KEY (flat_id) REFERENCES flat (flat_id) ON DELETE CASCADE
);

CREATE TABLE purchase_agreement
(
    purchase_agreement_id serial NOT NULL,
    central_firm_approved bool DEFAULT FALSE,
    flat_id               int8   NOT NULL,
    date_of_issue         date   NOT NULL,
    CONSTRAINT purchase_agreement_pkey PRIMARY KEY (purchase_agreement_id),
    CONSTRAINT fk_flat FOREIGN KEY (flat_id) REFERENCES flat (flat_id) ON DELETE CASCADE
);

CREATE TABLE flat_request
(
    flat_id                  serial NOT NULL,
    client_id                int8,
    floor_number_lower_bound int4,
    floor_number_upper_bound int4,
    total_area_lower_bound   int4,
    total_area_upper_bound   int4,
    price_lower_bound        int4,
    price_upper_bound        int4,
    rooms_number_lower_bound int4,
    rooms_number_upper_bound int4,
    description              text
);

CREATE TABLE flat_request_cache
(
    flat_request_cache_id    serial        NOT NULL,
    floor_number_lower_bound int4,
    floor_number_upper_bound int4,
    total_area_lower_bound   int4,
    total_area_upper_bound   int4,
    price_lower_bound        int4,
    price_upper_bound        int4,
    rooms_number_lower_bound int4,
    rooms_number_upper_bound int4,
    description              text,
    first_name               varchar(1024) NOT NULL,
    last_name                varchar(1024) NOT NULL,
    email                    varchar(1024) NULL,
    phone_number             varchar(1024) NOT NULL
);

CREATE TABLE agreement_document
(
    agreement_document_id serial        NOT NULL,
    doc_type              varchar(1024) NOT NULL,
    purchase_agreement_id int8          NOT NULL,
    broker_approved       bool DEFAULT FALSE,
    CONSTRAINT agreement_document_pkey PRIMARY KEY (agreement_document_id),
    CONSTRAINT fk_purchase_agreement FOREIGN KEY (purchase_agreement_id) REFERENCES purchase_agreement (purchase_agreement_id) ON DELETE CASCADE
);