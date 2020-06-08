drop table if exists ingredients;
drop table if exists dishes;

create table ingredients(
    id integer not null auto_increment,
    dish_id integer,
    name varchar(30) not null,
    type varchar(30),
    price double(10, 2),
    measure_unit varchar(30),
    quantity double(10, 2),
    description varchar(300),
    primary key(id),
    foreign key(dish_id) references dishes(id)
);

create table dishes(
    id integer not null auto_increment,
    name varchar(30) not null,
    type varchar(30),
    price double(10, 2),
    description varchar(300),
    primary key(id)
);