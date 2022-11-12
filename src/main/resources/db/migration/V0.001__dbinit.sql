CREATE SEQUENCE IF NOT EXISTS telephonebook_db.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE working_place
(
    working_place VARCHAR(255),
    phone_id      BIGINT NOT NULL,
    worker_id     BIGINT NOT NULL,
    CONSTRAINT pk_workingplace PRIMARY KEY (phone_id, worker_id)
);

CREATE TABLE telephonebook_db.phone_numbers
(
    id        BIGINT NOT NULL,
    number    VARCHAR(255),
    is_public BOOLEAN,
    CONSTRAINT pk_phone_numbers PRIMARY KEY (id)
);

CREATE TABLE telephonebook_db.workers
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255),
    surname      VARCHAR(255),
    patronymic   VARCHAR(255),
    working_mail VARCHAR(255),
    position     VARCHAR(255),
    CONSTRAINT pk_workers PRIMARY KEY (id)
);

ALTER TABLE working_place
    ADD CONSTRAINT FK_WORKINGPLACE_ON_PHONE FOREIGN KEY (phone_id) REFERENCES telephonebook_db.phone_numbers (id);

ALTER TABLE working_place
    ADD CONSTRAINT FK_WORKINGPLACE_ON_WORKER FOREIGN KEY (worker_id) REFERENCES telephonebook_db.workers (id);