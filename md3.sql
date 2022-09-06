create database students;
use students;
create table student(
    id int primary key  auto_increment,
    name nvarchar(255),
    dateOfBirth date,
    address nvarchar(255),
    phone nvarchar(255),
    email nvarchar(255),
    classroom_id int ,
    foreign key (classroom_id) references classroom(id)
);
create table classroom(
    id int primary key auto_increment,
    className nvarchar(255)
);
drop database students