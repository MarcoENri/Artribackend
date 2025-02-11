CREATE TABLE IF NOT EXISTS member(
    id SERIAL,
    nickname VARCHAR(25) NOT NULL,
    name VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    age INT NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR (25) NOT NULL,
    role VARCHAR(25) NOT NULL,
    PRIMARY KEY(id)
)