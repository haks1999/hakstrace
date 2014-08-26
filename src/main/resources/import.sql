--Authority
insert into Authorities (auth_code, auth_name, description) values ('SA','System Admin', 'Hakstrace system administrator');
insert into Authorities (auth_code, auth_name, description) values ('PA','Project Admin', 'Project administrator');
insert into Authorities (auth_code, auth_name, description) values ('NU','User', 'user');

--Menu
insert into Menu (menu_id, level, menu_name, url, seq, parent_menu_id) values ('sys',1,'System',null,1,null);
insert into Menu (menu_id, level, menu_name, url, seq, parent_menu_id) values ('sys_user',2,'Users','/system/users',1,'sys');

--User
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin1','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin2','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin3','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin4','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin5','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin6','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin7','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin8','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin9','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin10','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin11','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin12','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin13','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin14','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin15','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin16','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin17','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin18','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin19','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin20','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin21','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin22','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin23','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin24','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin25','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin26','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin27','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin28','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin29','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin30','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin31','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin32','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin33','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin34','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin35','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin36','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin37','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin38','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin39','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin40','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin41','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin42','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin43','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');