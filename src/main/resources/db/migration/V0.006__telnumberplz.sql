ALTER TABLE telephonebook_db.phone_numbers
    ADD tel_number VARCHAR(255);

ALTER TABLE telephonebook_db.phone_numbers
    DROP COLUMN number;