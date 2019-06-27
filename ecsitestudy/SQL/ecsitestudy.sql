set names utf8;
drop database if exists ecsitestudy;
create database ecsitestudy;
use ecsitestudy;
drop tables if exists user_info,product_info,cart_info,purchase_history_info,destination_info,m_category;

create table user_info(
id int primary key not null auto_increment,
user_id varchar(16) not null unique,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint default 1,
email varchar(32),
status tinyint default 0,
logined tinyint not null default 0,
regist_date datetime,
update_date datetime
);

create table m_category(
id int not null primary key auto_increment,
category_id int not null unique,
category_name varchar(20) not null unique,
category_description varchar(100),
insert_date datetime not null,
update_date datetime
);


create table product_info(
id int not null primary key auto_increment,
product_id int not null unique,
product_name varchar(100) not null unique,
product_name_kana varchar(100) not null unique,
product_description varchar(255),
category_id int not null,
price int not null,
image_file_path varchar(100) not null,
image_file_name varchar(50) not null,
release_date datetime,
release_company varchar(50),
status tinyint default 1,
regist_date datetime,
update_date datetime
);

create table destination_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
email varchar(32),
tel_number varchar(13) not null,
regist_date datetime,
update_date datetime
);

create table cart_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
product_id int not null,
product_count int not null,
price int,
regist_date datetime,
update_date datetime
);

create table purchase_history_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
product_id int not null,
product_count int,
price int,
destination_id int not null,
regist_date datetime,
update_date datetime
);

alter table product_info add foreign key (category_id) references m_category(category_id);
alter table destination_info add foreign key (user_id) references user_info(user_id);
alter table product_info add foreign key (category_id) references m_category(category_id);
alter table cart_info add foreign key (product_id) references product_info(product_id);
alter table purchase_history_info add foreign key (product_id) references product_info(product_id);
alter table purchase_history_info add foreign key (user_id) references user_info(user_id);
alter table purchase_history_info add foreign key (destination_id) references destination_info(id);





