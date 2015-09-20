INSERT INTO product (name,bar_code) VALUES ('DoriAnal','123456781');
INSERT INTO product (name,bar_code) VALUES ('DoriDemi','123456782');
INSERT INTO product (name,bar_code) VALUES ('Asal','123456783');
INSERT INTO product (name,bar_code) VALUES ('Подгузники','123456785');
INSERT INTO product (name,bar_code) VALUES ('Аналгин','123456787');
INSERT INTO product (name,bar_code) VALUES ('Демидрол','123456789');

INSERT INTO role(id, role) VALUES (1,'ROLE_VISITOR');
INSERT INTO role(id,role) VALUES (2, 'ROLE_ORGANIZATION_PUBLISHER');
INSERT INTO role(id, role) VALUES (3, 'ROLE_ORGANIZATION_ADMIN');
INSERT INTO role(id, role) VALUES (4, 'ROLE_SYSTEM_ADMIN');

INSERT INTO bileton_user (id, email, password, first_name, enabled) VALUES (1,'rusti_1993@mail.ru', 'password', 'ruslan', true);
INSERT INTO bileton_user (id, email, password, first_name, enabled) VALUES (2, 'nodirbek@mail.ru', 'password', 'Nodirbek', true);


INSERT INTO user_roles (user_id, role_id) VALUES (2,1);
INSERT INTO user_roles (user_id, role_id) VALUES (1,1);
INSERT INTO user_roles (user_id, role_id) VALUES (1,2);
INSERT INTO user_roles (user_id, role_id) VALUES (1,3);
INSERT INTO user_roles (user_id, role_id) VALUES (1,4);

INSERT INTO verification_token (token, user_id) VALUES ('it is working yahoo',1);