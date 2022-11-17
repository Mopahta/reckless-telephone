ALTER TABLE telephonebook_db.workers
    ADD worker_name VARCHAR(255);

ALTER TABLE telephonebook_db.workers
    DROP COLUMN name;