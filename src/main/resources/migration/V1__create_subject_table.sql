CREATE TABLE subject (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         hours INT NOT NULL,
                         mandatory BOOLEAN NOT NULL,
                         exam_type VARCHAR(255)
);
