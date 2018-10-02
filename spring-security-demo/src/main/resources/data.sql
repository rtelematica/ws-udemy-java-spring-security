insert into user(id, username, password) values(null, 'ivan', '123');
insert into user(id, username, password) values(null, 'ilse', '123');
insert into user(id, username, password) values(null, 'pau', 'gugu');

insert into authority(id, authority) values(null, 'ADMIN');
insert into authority(id, authority) values(null, 'USER');
insert into authority(id, authority) values(null, 'OTHER');

insert into user_authorities(user_id, authority_id) values(1, 1);
insert into user_authorities(user_id, authority_id) values(1, 2);
insert into user_authorities(user_id, authority_id) values(2, 1);
insert into user_authorities(user_id, authority_id) values(2, 2);
insert into user_authorities(user_id, authority_id) values(3, 1);
insert into user_authorities(user_id, authority_id) values(3, 2);
insert into user_authorities(user_id, authority_id) values(3, 3);