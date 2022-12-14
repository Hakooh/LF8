--Reihenfolge der Inserts ist relevant. Insertblöcke in der Reihenfolge nicht verändern.


--festival inserts
INSERT INTO festivals (address, end_date, festival_place, name, start_date) values ('Musterstrasse 8', '2022-1-3', 'Hamburg', 'Dom', '2022-1-1');

--Shop inserts
INSERT INTO shops(id, name, type) VALUES (1, 'Meyers Mandelbude', 'FOODSTORE');

--User inserts
insert into users ( day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values ( '1986-04-20', 'geilertyp@hotmail.de', 'Dieter', 'Male', '2022-08-12', 'Detlefs', 'password');
insert into users ( day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values ( '1985-03-10', 'test@hotmail.de', 'Gerda', 'Female', '2022-08-06', 'Gunde', 'password');
insert into users ( day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values ( '1984-06-22', 'mega@hotmail.de', 'Laura', 'Female', '2022-05-18', 'Schmidt', 'password');
insert into users ( day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values ( '1982-01-05', 'super@hotmail.de', 'Susanne', 'Female', '2022-07-10', 'Sunder', 'password');
insert into users ( day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values ( '1980-10-10', 'lolo@hotmail.de', 'Klaus', 'Male', '2022-09-03', 'Kong', 'password');

--Rating inserts
INSERT INTO ratings( comment, comment_date, rating, user_id) VALUES ('Freshe Sache', '2022-08-12', 4.5, 1);

--Festival - Shops inserts
INSERT INTO festivals_shops(festival_entity_id, shops_id) values (1, 1);

--Shops - Ratings inserts
insert into shops_ratings(shop_entity_id, ratings_id) values (1,1);





