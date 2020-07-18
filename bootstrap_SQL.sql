DROP TABLE IF EXISTS service_info;
DROP TABLE IF EXISTS service_name;
CREATE TABLE service_info(
    id int NOT NULL AUTO_INCREMENT,
    service_name_id int NOT NULL,
    availability varchar(255) NOT NULL,
    performance varchar(255) NOT NULL,
    quality varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE service_name (
	id int NOT NULL AUTO_INCREMENT,
    service_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE service_info ADD FOREIGN KEY (service_name_id) REFERENCES service_name(id);