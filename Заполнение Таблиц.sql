insert into achives(achive_name) VALUES ('Врач года!');
insert into achives(achive_name) VALUES ('Хирург-золотые ручки');


insert into hospitals(hos_name,country,city,address,about) VALUES ('Городская больница №1','Россия','Казань','Улица Вишневского 2','---');
insert into hospitals(hos_name,country,city,address,about) VALUES ('Городская больница №2','Россия','Казань','Улица Разбитых Фонарей 17','---');

insert into special(special_name) VALUES ('Терапевт');
insert into special(special_name) VALUES ('Хирург');
insert into special(special_name) VALUES ('ЛОР');
insert into special(special_name) VALUES ('Стоматолог');

insert into doctors(doc_name, id_spec) VALUES ('Василий Иванович Скоробогатько', 5);
insert into doctors(doc_name, id_spec) VALUES ('Энтони Говард Старк', 6);
insert into doctors(doc_name, id_spec) VALUES ('Ай Бо Лит', 7);

insert into doctor_achive(id_doctor, id_achive) VALUES (5,6);
insert into doctor_achive(id_doctor, id_achive) VALUES (6,5);

insert into week_days VALUES (1, 'Пн');
insert into week_days VALUES (2, 'Вт');
insert into week_days VALUES (3, 'Ср');
insert into week_days VALUES (4, 'Чт');
insert into week_days VALUES (5, 'Пт');
insert into week_days VALUES (6, 'Сб');

insert into times(doc_id, day_id, day_time) VALUES (5,2,'10:00');
insert into times(doc_id, day_id, day_time) VALUES (6,1,'10:30');
insert into times(doc_id, day_id, day_time) VALUES (2,2,'11:00');

insert into hos_dor(hos_id, doc_id) VALUES (3,2);
insert into hos_dor(hos_id, doc_id) VALUES (4,5);
