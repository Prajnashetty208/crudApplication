DROP TABLE IF EXISTS personal_details CASCADE;
DROP TABLE IF EXISTS contact_details CASCADE;
DROP TABLE IF EXISTS status_details CASCADE;
DROP TABLE IF EXISTS order_table CASCADE;
CREATE TABLE personal_details (
   user_id int PRIMARY KEY,
   firstName varchar(20) NOT NULL,
   address varchar(20) NOT NULL,
   status_id varchar(20) NOT NULL
);

ALTER TABLE personal_details 
ADD CONSTRAINT fk_status FOREIGN KEY(status_id)  REFERENCES status_details(status_id);


INSERT INTO personal_details(user_id, firstName, address, status_id)
VALUES (123, 'Sai', 'Mijar',1);


CREATE TABLE contact_details (
   contact_id int PRIMARY KEY,
   user_id int,
   phone varchar(20) NOT NULL
   
);

INSERT INTO contact_details(contact_id, user_id, phone)
VALUES (33, 123, '2345678');

ALTER TABLE contact_details 
ADD CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES personal_details(user_id);

CREATE TABLE status_details (
status varchar(20) NOT NULL,
   status_id varchar(20) PRIMARY KEY NOT NULL
);


INSERT INTO status_details(status,status_id)
VALUES ('YES',1);
INSERT INTO status_details(status,status_id)
VALUES ('No',2);
INSERT INTO status_details(status,status_id)
VALUES ('Ok',3);

INSERT INTO roles(id,name,password,role)
VALUES (10,'abc','abc','USER');

Update roles set password ='$2a$12$wGVEuT8oZ9fLizib3J31i.KIK1GsKHsSZ4pD/YKBIAyKZaR2FKKPG'
where name='abc';

//ALTER USER postgres WITH PASSWORD 'password';

SELECT * FROM personal_details p join order_table o on o.user_id = p.user_id WHERE o.order_id = 12;