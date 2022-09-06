create database students;
use students;
create table classroom
(
    id        int primary key auto_increment,
    className nvarchar(255)
);
create table student
(
    id           int primary key auto_increment,
    name         nvarchar(255),
    dateOfBirth  date,
    address      nvarchar(255),
    phone        nvarchar(255),
    email        nvarchar(255),
    classroom_id int,
    foreign key (classroom_id) references classroom (id)
);
insert into classroom(className) VALUE ('c0522g1');
insert into classroom(className) VALUE ('c0522g2');
insert into classroom(className) VALUE ('c0522g3');
insert into classroom(className) VALUE ('c0522g4');
insert into classroom(className) VALUE ('c0522g5');

insert into student(name, dateOfBirth, address, phone, email, classroom_id) value ('quyet','2001-09-07','BN','04824023','qutete@gmail.com',1);
insert into student(name, dateOfBirth, address, phone, email, classroom_id) value ('quye','2001-09-07','BN','04824023','qutete@gmail.com',2);
insert into student(name, dateOfBirth, address, phone, email, classroom_id) value ('quyt','2001-09-07','BN','04824023','qutete@gmail.com',3);
insert into student(name, dateOfBirth, address, phone, email, classroom_id) value ('quet','2001-09-07','BN','04824023','qutete@gmail.com',4);
insert into student(name, dateOfBirth, address, phone, email, classroom_id) value ('qyet','2001-09-07','BN','04824023','qutete@gmail.com',5);
drop database students;
