use na;

alter table wine
add column fk_name varchar(255) not null after quantity,
add column fk_description varchar(255) not null after fk_name,
add column fk_estimatedPrice int not null after fk_description,
add column fk_picturePath varchar(255) not null after fk_estimatedPrice,
add foreign key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath) references product (p_name, p_description, p_estimatedPrice, p_picturePath),
add primary key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath);

alter table furniture
add column fk_name varchar(255) not null after dimensions,
add column fk_description varchar(255) not null after fk_name,
add column fk_estimatedPrice int not null after fk_description,
add column fk_picturePath varchar(255) not null after fk_estimatedPrice,
add foreign key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath) references product (p_name, p_description, p_estimatedPrice, p_picturePath),
add primary key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath);

alter table painting
add column fk_name varchar(255) not null after size,
add column fk_description varchar(255) not null after fk_name,
add column fk_estimatedPrice int not null after fk_description,
add column fk_picturePath varchar(255) not null after fk_estimatedPrice,
add foreign key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath) references product (p_name, p_description, p_estimatedPrice, p_picturePath),
add primary key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath);

alter table jewellery
add column fk_name varchar(255) not null after stamp,
add column fk_description varchar(255) not null after fk_name,
add column fk_estimatedPrice int not null after fk_description,
add column fk_picturePath varchar(255) not null after fk_estimatedPrice,
add foreign key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath) references product (p_name, p_description, p_estimatedPrice, p_picturePath),
add primary key (fk_name, fk_description, fk_estimatedPrice, fk_picturePath);

alter table bid
add column fk_userName varchar(255) not null after bid_time,
add column fk_address varchar(255) not null after bid_time,
add column fk_phoneNumber int not null after bid_time,
add foreign key (fk_userName, fk_address, fk_phoneNumber) references user (userName, address, phoneNumber),
add primary key (fk_userName, fk_address, fk_phoneNumber, bid_time);
