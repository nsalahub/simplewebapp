CREATE TYPE gender_employee AS ENUM ('male', 'female');
CREATE TABLE IF NOT EXISTS employee(
employee_id serial primary key,
first_name varchar not null,
last_name varchar not null,
department_id bigint not null,
job_title varchar not null,
gender gender_employee not null,
date_of_birdth date not null,
deleted boolean default false not null);

INSERT INTO employee(first_name,last_name,department_id,
job_title,gender,date_of_birdth,deleted) VALUES(
						   '1'
						   ,'asa'
						   ,1
						   ,'boss'
						   ,'male'
						   ,'1999-01-08'
						   ,'false'
						  );