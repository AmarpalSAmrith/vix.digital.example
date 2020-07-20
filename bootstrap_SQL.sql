DROP TABLE IF EXISTS service_info;
DROP TABLE IF EXISTS service_name;
DROP TABLE IF EXISTS quality_categories;
CREATE TABLE service_info(
    id int NOT NULL AUTO_INCREMENT,
    service_name_id int NOT NULL,
    availability int NOT NULL,
    performance varchar(255) NOT NULL,
    quality_id int NOT NULL,
    service_check_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE service_name (
	id int NOT NULL AUTO_INCREMENT,
    service_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE quality_categories (
	id int NOT NULL AUTO_INCREMENT,
    category varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE service_info ADD FOREIGN KEY (service_name_id) REFERENCES service_name(id);
ALTER TABLE service_info ADD FOREIGN KEY (quality_id) REFERENCES quality_categories(id);

INSERT INTO service_name(service_name) VALUES ('https://vix.digital');

INSERT INTO quality_categories(id, category) VALUES (1, 'red');

INSERT INTO quality_categories(id, category) VALUES (2, 'amber');

INSERT INTO quality_categories(id, category) VALUES (3, 'green');

