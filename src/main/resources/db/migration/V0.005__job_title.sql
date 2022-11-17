ALTER TABLE telephonebook_db.workers
    ADD job_title VARCHAR(255);

ALTER TABLE telephonebook_db.workers
    DROP COLUMN position;