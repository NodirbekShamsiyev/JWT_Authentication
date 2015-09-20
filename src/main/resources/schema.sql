CREATE TABLE product (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(255),
  bar_code VARCHAR(45)
);

CREATE TABLE bileton_user(
  id BIGINT AUTO_INCREMENT,
  email VARCHAR (255),
  password VARCHAR (255),
  first_name VARCHAR (255),
  last_name VARCHAR (255),
  enabled BOOLEAN,
  tokenExpired BOOLEAN
);


CREATE TABLE verification_token(
  id BIGINT AUTO_INCREMENT,
  token VARCHAR (255),
  user_id INT ,
  date_expired DATE,
  FOREIGN KEY (user_id) REFERENCES bileton_user(id)
);


CREATE TABLE role(
  id BIGINT AUTO_INCREMENT,
  role VARCHAR (255),
);

CREATE TABLE user_roles(
  id BIGINT AUTO_INCREMENT,
  user_id INT,
  role_id INT,
  FOREIGN KEY (user_id) REFERENCES bileton_user(id),
  FOREIGN KEY  (role_id) REFERENCES role(id)
);