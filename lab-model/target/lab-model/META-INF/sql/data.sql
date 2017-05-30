INSERT INTO student(std_index, std_firstname, std_surname) VALUES (275789, 'Mateusz', 'Wydmanski');
INSERT INTO student(std_index, std_firstname, std_surname) VALUES (275252, 'Michał', 'Kałduś');
INSERT INTO student(std_index, std_firstname, std_surname) VALUES (278572, 'Marcin', 'Flis');
INSERT INTO student(std_index, std_firstname, std_surname) VALUES (123451, 'Damian', 'Pasek');
INSERT INTO student(std_index, std_firstname, std_surname) VALUES (214512, 'Marcin', 'Nalepa');

INSERT INTO course(crs_id, crs_ects, crs_name) VALUES (1, 5, 'SOA');
INSERT INTO course(crs_id, crs_ects, crs_name) VALUES (2, 5, 'PSI');
INSERT INTO course(crs_id, crs_ects, crs_name) VALUES (3, 5, 'TKiK');

INSERT INTO course_student(crs_id, std_index) VALUES (1,275789);
INSERT INTO course_student(crs_id, std_index) VALUES (2,275789);
INSERT INTO course_student(crs_id, std_index) VALUES (3,275789);
INSERT INTO course_student(crs_id, std_index) VALUES (1,275252);
INSERT INTO course_student(crs_id, std_index) VALUES (2,275252);
INSERT INTO course_student(crs_id, std_index) VALUES (3,275252);
INSERT INTO course_student(crs_id, std_index) VALUES (1,278572);
INSERT INTO course_student(crs_id, std_index) VALUES (2,278572);
INSERT INTO course_student(crs_id, std_index) VALUES (3,278572);
INSERT INTO course_student(crs_id, std_index) VALUES (1,123451);
INSERT INTO course_student(crs_id, std_index) VALUES (2,123451);
INSERT INTO course_student(crs_id, std_index) VALUES (3,123451);
INSERT INTO course_student(crs_id, std_index) VALUES (3,214512);
