CREATE TABLE person_occupation (
person_id INTEGER,
occupation_id INTEGER,
CONSTRAINT FK_person_person_occupation FOREIGN KEY (person_id) REFERENCES person(id),
CONSTRAINT FK_occupation_person_occupation FOREIGN KEY (occupation_id) REFERENCES occupation(id),
CONSTRAINT PK_person_occupation PRIMARY KEY (person_id, occupation_id));