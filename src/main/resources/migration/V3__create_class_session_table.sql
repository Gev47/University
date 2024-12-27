CREATE TABLE class_session (
                               id SERIAL PRIMARY KEY,
                               date DATE NOT NULL,
                               time TIME NOT NULL,
                               auditorium VARCHAR(100) NOT NULL,
                               class_type VARCHAR(50) NOT NULL,
                               group_name VARCHAR(100),
                               teacher_id INT NOT NULL,
                               subject_id INT NOT NULL,
                               metadata JSONB,
                               notes TEXT,
                               CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teacher (id) ON DELETE CASCADE,
                               CONSTRAINT fk_subject FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);
