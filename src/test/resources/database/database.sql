CREATE TABLE postgres.public.users IF NOT EXISTS (
id SERIAL NOT NULL PRIMARY KEY,
username VARCHAR (255) NOT NULL,
password VARCHAR (255) NOT NULL
);

