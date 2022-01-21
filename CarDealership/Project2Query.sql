CREATE TABLE car (
	id INT NOT NULL AUTO_INCREMENT,
    make VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    build VARCHAR(100),
    image BLOB,
    PRIMARY KEY(id)
);

CREATE TABLE inventory (
	id INT NOT NULL AUTO_INCREMENT,
    car_id INT NOT NULL,
    type VARCHAR(100) NOT NULL,
    purchase_date DATETIME,
    miles INT,
    price DOUBLE,
    description TEXT,
    is_sold BOOLEAN,
    PRIMARY KEY(id),
    FOREIGN KEY(car_id) REFERENCES car(id)
);

CREATE TABLE sale (
	id INT NOT NULL AUTO_INCREMENT,
    inventory_id INT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    purchase_date DATETIME,
    PRIMARY KEY(id),
    FOREIGN KEY(inventory_id) REFERENCES inventory(id)
);