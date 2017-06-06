CREATE TABLE user (
	id INTEGER NOT NULL AUTO_INCREMENT,
	active BOOLEAN NOT NULL,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	name VARCHAR(32) NOT NULL,
	surname VARCHAR(32) NOT NULL,
	second_surname VARCHAR(32),
	PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ndx_user_username ON user(username);
