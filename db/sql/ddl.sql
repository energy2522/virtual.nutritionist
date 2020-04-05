drop schema if exists `vir-nut`;
create schema `vir-nut` collate utf8_general_ci;

use `vir-nut`;

create table category
(
    id int auto_increment
        primary key,
    name varchar(100) not null,
    description varchar(255) null,
    constraint category_name_uindex
        unique (name)
);

create table diet
(
    id int auto_increment
        primary key,
    name varchar(100) not null,
    type varchar(50) not null
);

create table dish_type
(
    id int auto_increment
        primary key,
    name varchar(100) not null,
    description varchar(255) null,
    constraint DishType_name_uindex
        unique (name)
);

create table dish
(
    id int auto_increment
        primary key,
    type_id int not null,
    name varchar(150) not null,
    recipe varchar(800) not null,
    constraint dish_dish_type_fk
        foreign key (type_id) references dish_type (id)
);

create table product
(
    id int auto_increment
        primary key,
    name varchar(100) not null,
    calories double not null,
    carbohydrates double not null,
    proteins double not null,
    fats double not null,
    category_id int not null,
    constraint product_category_fk
        foreign key (category_id) references category (id)
);

create table ingredient
(
    dish_id int default 0 not null,
    product_id int default 0 not null,
    weight double not null,
    primary key (dish_id, product_id),
    constraint ingredient_dish_fk
        foreign key (dish_id) references dish (id),
    constraint ingredient_product_fk
        foreign key (product_id) references product (id)
);

create table role
(
    id int auto_increment
        primary key,
    name varchar(20) not null,
    description varchar(200) null,
    constraint role_name_uindex
        unique (name)
);

create table schedule
(
    id int auto_increment
        primary key,
    dish_id int not null,
    diet_id int not null,
    day date not null,
    time time not null,
    constraint schedule_diet_fk
        foreign key (diet_id) references diet (id),
    constraint schedule_dish_fk
        foreign key (dish_id) references dish (id)
);

create table user
(
    id int auto_increment
        primary key,
    username varchar(20) not null,
    password varchar(255) not null,
    age int not null,
    email varchar(100) null,
    sex varchar(10) null,
    weight double null,
    height double null,
    role_id int not null,
    constraint user_email_uindex
        unique (email),
    constraint user_username_uindex
        unique (username),
    constraint user_role__fk
        foreign key (role_id) references role (id)
);

create table personal_diet
(
    id int auto_increment
        primary key,
    user_id int not null,
    diet_id int not null,
    start_date date not null,
    end_date date not null,
    goal double not null,
    constraint personal_diet_diet_fk
        foreign key (diet_id) references diet (id),
    constraint personal_diet_user_fk
        foreign key (user_id) references user (id)
);

create table measurement
(
    id int auto_increment
        primary key,
    weight double not null,
    date date not null,
    personal_diet_id int null,
    constraint measurement_personal_diet_fk
        foreign key (personal_diet_id) references personal_diet (id)
);

create table personal_schedule
(
    id int auto_increment
        primary key,
    day date not null,
    time time not null,
    done tinyint(1) default 0 not null,
    personal_diet_id int not null,
    constraint personal_schedule_personal_diet_fk
        foreign key (personal_diet_id) references personal_diet (id)
);

