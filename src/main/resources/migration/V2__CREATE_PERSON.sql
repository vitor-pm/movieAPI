CREATE TABLE public.person (
	id bigserial NOT NULL,
	"name" varchar(255) NOT NULL,
	nacionality varchar(255) NULL,
	gender bpchar(1) NULL,
	biography varchar(255) NULL,
	birth_date date NULL,
	created_at timestamp(6) NULL,
   	updated_at timestamp(6) NULL,
	CONSTRAINT PK_person PRIMARY KEY (id)
);