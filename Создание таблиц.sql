CREATE TABLE hospitals(
	id SERIAL PRIMARY KEY,
	hos_name varchar NOT NULL,
	country varchar(20) NOT NULL,
	city varchar(20) NOT NULL,
	address text,
	about text
	);
	CREATE TABLE special(
	id SERIAL PRIMARY KEY,
	special_name varchar NOT NULL
	);
	CREATE TABLE achives(
	id SERIAL PRIMARY KEY,
	achive_name varchar NOT NULL
	);
	CREATE TABLE doctors(
	id SERIAL PRIMARY KEY,
	doc_name varchar NOT NULL,
	id_spec int, 
	FOREIGN KEY(id_spec) REFERENCES special(id)
	);
	CREATE TABLE doctor_achive(
	id_doctor int,
	id_achive int,
	FOREIGN KEY(id_doctor) REFERENCES doctors(id),
	FOREIGN KEY(id_achive) REFERENCES achives(id)
	);
CREATE TABLE week_days (
	id int PRIMARY KEY,
	day varchar (2)
	);

CREATE TABLE times (
	id SERIAL PRIMARY KEY,
	doc_id int,
	day_id int,
	day_time varchar(5),
	FOREIGN KEY(doc_id) REFERENCES doctors(id),
	FOREIGN KEY(day_id) REFERENCES week_days(id)
	);



	
CREATE TABLE hos_dor(
	hos_id int,
	doc_id int,
	FOREIGN KEY(doc_id) REFERENCES doctors(id),
	FOREIGN KEY(hos_id) REFERENCES hospitals(id)
	);



 CREATE TABLE users(
	id SERIAL PRIMARY KEY,
	user_name varchar(15),
	user_surname varchar(20),
	city varchar(20),
	user_login varchar(20) NOT NULL,
	user_pasword varchar(20) NOT NULL
	);

CREATE TABLE zan(
	id_time int,
	id_user int,
	FOREIGN KEY(id_time) REFERENCES times(id),
	FOREIGN KEY(id_user) REFERENCES users(id)	
	);

