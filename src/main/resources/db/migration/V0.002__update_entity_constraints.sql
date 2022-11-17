CREATE TABLE telephonebook_db.departments
(
    dep_id BIGINT NOT NULL,
    name   VARCHAR(255),
    CONSTRAINT pk_departments PRIMARY KEY (dep_id)
);

ALTER TABLE telephonebook_db.phone_numbers
    ADD dep_id BIGINT;

ALTER TABLE telephonebook_db.workers
    ADD dep_id BIGINT;

ALTER TABLE telephonebook_db.phone_numbers
    ADD CONSTRAINT FK_PHONE_NUMBERS_ON_DEP FOREIGN KEY (dep_id) REFERENCES telephonebook_db.departments (dep_id);

ALTER TABLE telephonebook_db.workers
    ADD CONSTRAINT FK_WORKERS_ON_DEP FOREIGN KEY (dep_id) REFERENCES telephonebook_db.departments (dep_id);

ALTER TABLE telephonebook_db.working_place
    DROP CONSTRAINT fk_workingplace_on_phone;

ALTER TABLE telephonebook_db.working_place
    DROP CONSTRAINT fk_workingplace_on_worker;

DROP TABLE telephonebook_db.working_place CASCADE;