drop table if exists ingredients;
drop table if exists dishes;
drop table if exists dish_quantities;
drop table if exists table_orders;
drop table if exists employees;
drop table if exists roles;

create table ingredients(
    id integer not null auto_increment,
    name varchar(30) not null,
    type varchar(30),
    price double(10, 2),
    measure_unit varchar(30),
    quantity double(10, 2),
    description varchar(300),
    primary key(id)
);

create table dishes(
    id integer not null auto_increment,
    name varchar(30) not null,
    type varchar(30),
    price double(10, 2),
    description varchar(300),
    primary key(id)
);

create table dish_quantities(
    id integer not null auto_increment,
    dishQuantity integer,
    primary key(id)
);

create table table_orders(
    id integer not null auto_increment,
    description varchar(300),
    createdTime datetime not null,
    closedTime datetime not null,
    status varchar(30),
    totalCost double(10, 2),
    primary key(id)
);

create table employees(
    id integer not null auto_increment,
    name varchar(30) not null,
    description varchar(300),
    firstName varchar(30),
    lastName varchar(30),
    phone varchar(30),
    email varchar(100),
    hireDate date,
    primary key(id)
);

create table roles(
    id integer not null auto_increment,
    name varchar(30) not null,
    description varchar(300),
    primary key(id)
);

alter table ingredients(
    dish_id integer,
    foreign key (dish_id) references dishes (id)
);