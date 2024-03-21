--Swedbank demo database

--Person table
CREATE TABLE person
(
    pid         bigint PRIMARY KEY,
    first_name  varchar(255) not null,
    middle_name varchar(255),
    last_name   varchar(255) not null,
    email       varchar(255),
    phone       varchar(255)
);

--Person data

INSERT INTO person (pid, first_name, middle_name, last_name, email, phone)
VALUES (39001234567, 'Jonas', 'Mikalojus', 'Jonaitis', 'jonas.jonaitis@example.com', '+37061234567'),
       (49001123456, 'Janina', 'Marija', 'Petrauskienė', 'janina.petrauskiene@example.com', '+37061234568'),
       (69002234567, 'Domas', NULL, 'Jonaitis', 'domas.jonaitis@example.com', '+37061234569'),
       (49002345678, 'Emilija', 'Gražina', 'Bružaitė', 'emilija.bruzaite@example.com', '+37061234570'),
       (59003456789, 'Mikalojus', 'Linas', 'Valinskis', 'mikalojus.valinskis@example.com', '+37061234571');