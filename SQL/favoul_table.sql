create table delivery_method(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(256) UNIQUE not null,
price int not null
);

create table item(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(256) NOT NULL,
detail text NOT NULL,
price int NOT NULL,
file_name varchar(256) NOT NULL,
item_category_id int NOT NULL,
create_date date NOT NULL
);


create table user(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(256) NOT NULL,
address varchar(256) NOT NULL,
password varchar(256) NOT NULL,
birth_date date NOT NULL,
create_date date NOT NULL
);

create table item_category(
id int PRIMARY KEY AUTO_INCREMENT,
category varchar(100) NOT NULL
);

create table trivia(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(256) NOT NULL,
detail text NOT NULL,
item_category_id int NOT NULL
);

create table buy(
id int PRIMARY KEY AUTO_INCREMENT,
user_id int NOT NULL,
total_price int NOT NULL,
delivery_method_id int NOT NULL,
create_date datetime NOT NULL
);


create table buy_detail(
id int PRIMARY KEY AUTO_INCREMENT,
buy_id int NOT NULL,
item_id int NOT NULL
);

create table food(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(256) NOT NULL,
detail text NOT NULL,
file_name varchar(256) NOT NULL
);

create table food_best_much(
id int PRIMARY KEY AUTO_INCREMENT,
food_id int NOT NULL,
item_id int NOT NULL
)