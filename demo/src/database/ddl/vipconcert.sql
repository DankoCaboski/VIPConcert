CREATE table events (
	eventId serial NOT NULL,
	imgId serial,
	eventName VARCHAR(20),
	description VARCHAR(30),
	genre VARCHAR(20),
	inicio timestamp without time zone,
	fim timestamp without time zone,
	PRIMARY KEY (eventId)
);

CREATE table users(
	pid serial NOT NULL,
	password VARCHAR(30),
	email VARCHAR(40),
	name VARCHAR(40),
	cpf VARCHAR(11) NOT NULL,
	role VARCHAR(11) NOT NULL,
	status VARCHAR(11) NOT NULL,
	PRIMARY KEY (cpf)
);

CREATE table participation (
	eventId serial NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	FOREIGN KEY (eventId) REFERENCES events(eventId),
    FOREIGN KEY (cpf) REFERENCES users(cpf)
)