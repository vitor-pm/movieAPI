CREATE TABLE movie (
  id SERIAL NOT NULL,
  title varchar(255) NOT NULL,
  release_date date NOT NULL,
  rating decimal,
  created_at timestamp,
  updated_at timestamp,
  CONSTRAINT PK_movie PRIMARY KEY (id)
);