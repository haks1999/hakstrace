--Authority
insert into Authorities (auth_code, auth_name, description) values ('SA','System Admin', 'Hakstrace system administrator');
insert into Authorities (auth_code, auth_name, description) values ('PA','Project Admin', 'Project administrator');
insert into Authorities (auth_code, auth_name, description) values ('NU','user', 'user');

--User
insert into Users (user_id, user_name, email, password, authority_auth_code) values ('admin','administrator','admin@gamil.com','$2a$10$.4CMhs.WEuaurRXXO2SftuQEUzRLwOejYQbwCjj8mWCe1uUbofYjS', 'SA');