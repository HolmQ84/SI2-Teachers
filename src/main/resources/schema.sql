DROP TABLE IF EXISTS TEACHER;

CREATE TABLE TEACHER
(
    teacher_id     LONG          PRIMARY KEY,
    name           VARCHAR(50)   NOT NULL,
    age            INT           NOT NULL,
    mail           VARCHAR(50)   NOT NULL,
    subject        VARCHAR(50)   NOT NULL
);