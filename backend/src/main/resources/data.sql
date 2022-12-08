--Reihenfolge der Inserts ist relevant. Insertblöcke in der Reihenfolge nicht verändern.


--festival inserts
INSERT INTO festivals (id, address, end_date, festival_place, name, start_date) values (1, 'Musterstrasse 8', '2022-1-3', 'hamburg', 'dom', '2022-1-1');

--Shop inserts
INSERT INTO shops(id, name, type) VALUES (1, 'Meyers Mandelbude', 'FOODSTORE');

--User inserts
insert into users (id, day_of_birth, e_mail, first_name, gender, last_login, last_name, password) values (1, '1986-04-20', 'geilertyp@hotmail.de', 'Dieter', 'Male', '2022-08-12', 'Detlefs', 'password');

--Rating inserts
INSERT INTO ratings(id, comment, comment_date, rating, user_id) VALUES (1, 'Freshe Sache', '2022-08-12', 4.5, 1);

--Festival - Shops inserts
INSERT INTO festivals_shops(festival_entity_id, shops_id) values (1, 1);

--Shops - Ratings inserts
insert into shops_ratings(shop_entity_id, ratings_id) values (1,1);





