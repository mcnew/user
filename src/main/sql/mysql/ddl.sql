CREATE TABLE user (
	id INTEGER NOT NULL AUTO_INCREMENT,
	active BOOLEAN NOT NULL,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	name VARCHAR(32) NOT NULL,
	surname VARCHAR(32) NOT NULL,
	second_surname VARCHAR(32),
	creation TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ndx_user_username ON user(username);

CREATE TABLE password (
	id INTEGER NOT NULL AUTO_INCREMENT,
	user_id INTEGER NOT NULL,
	old VARCHAR(32) NOT NULL,
	creation TIMESTAMP NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE UNIQUE INDEX ndx_password_alt ON password(old);
