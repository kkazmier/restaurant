drop table if exists ingredients;
drop table if exists dishes;
drop table if exists dish_quantities;
drop table if exists table_orders;
drop table if exists roles;
drop table if exists employees;


create table employees
(
    id          integer     not null auto_increment,
    name        varchar(30) not null,
    description varchar(300),
    firstName   varchar(30),
    lastName    varchar(30),
    phone       varchar(30),
    email       varchar(100),
    hireDate    date,
    primary key (id)
);

create table roles
(
    id          integer     not null auto_increment,
    employee_id integer,
    name        varchar(30) not null,
    description varchar(300),
    primary key (id),
    foreign key (employee_id) references employees (id)
);

create table table_orders
(
    id          integer  not null auto_increment,
    employee_id integer,
    description varchar(300),
    createdTime datetime not null,
    closedTime  datetime not null,
    status      varchar(30),
    totalCost   double(10, 2),
    primary key (id),
    foreign key (employee_id) references employees (id)
);

create table dish_quantities
(
    id           integer not null auto_increment,
    dish_id      integer,
    dishQuantity integer,
    primary key (id),
    foreign key (dish_id) references dishes (id)
);

create table dishes
(
    id          integer     not null auto_increment,
    name        varchar(30) not null,
    type        varchar(30),
    price       double(10, 2),
    description varchar(300),
    primary key (id)
);

create table ingredients
(
    id           integer     not null auto_increment,
    dish_id      integer,
    name         varchar(30) not null,
    type         varchar(30),
    price        double(10, 2),
    measure_unit varchar(30),
    quantity     double(10, 2),
    description  varchar(300),
    primary key (id),
    foreign key (dish_id) references dishes (id)
);
-- ------------------------------------------------------------------------------------------------
insert into employees
values (1, 'kelner', 'kelner', 'Jan', 'Kowalski', '123456789', 'kowalski@mail.com', '2010-12-12');

insert into roles
values (1, 1, 'kelner', 'kelner');

insert into table_orders
values (1, 1, 'pierwsze zamowienie', '2020-02-02 12:22:22', '2020-02-02 12:23:22', 'zrealizowane', 30.0);

insert into dishes
values (1, 1, 'Zestaw obiadowy 1', 'zestaw obiadowy', 20.0, 'Tylko w godz. 12-16');

insert into dishes
values (2, 1, 'mizeria', 'sałatka', 5.0, 'brak');

insert into ingredients
values (1, 1, 'ziemniaki', 'warzywo', 2.0, 'kg', 300, null);
insert into ingredients
values (2, 1, 'cebula', 'warzywo', 3.0, 'kg', 100, null);
insert into ingredients
values (3, 1, 'marchew', 'warzywo', 2.0, 'kg', 100, null);
insert into ingredients
values (4, 1, 'wieprzowina', 'mięso', 20.0, 'kg', 100, null);
insert into ingredients
values (5, 1, 'śmietana', 'nabiał', 10.0, 'kg', 50, null);
insert into ingredients
values (6, 2, 'ogórki', 'warzywo', 4.0, 'kg', 150, null);
insert into ingredients
values (7, 2, 'śmietana', 'nabiał', 10.0, 'kg', 50, null);

select *
from employees;
select *
from table_orders;
select *
from dishes;
select *
from ingredients;
select *
from employees;
select *
from roles;