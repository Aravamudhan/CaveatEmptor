--liquibase formatted sql
--changeset amudhan:1
drop table if exists category_parent;
drop table if exists category;
drop table if exists itemimages;
drop table if exists item;
drop table if exists image;
drop table if exists useraddress;
drop table if exists address;
drop table if exists sellingitems;
drop table if exists biddingitems;
drop table if exists bid;
drop table if exists bankaccount;
drop table if exists creditcard;
drop table if exists billingdetails;
drop table if exists user_details;

create table category(id int unsigned primary key auto_increment, name varchar(50));
create table category_parent(cid int unsigned not null, parentid int unsigned not null, primary key(cid, parentid), 
	constraint fk_cid foreign key(cid) references category(id) on delete cascade, 
	constraint fk_pid foreign key(parentid) references category(id) on delete cascade);
create table item(id int unsigned primary key auto_increment, name varchar(100), initialprice decimal, auctionstart date, 
	auctionend date, description text);
create table image(id int unsigned primary key auto_increment, name varchar(50), imageurl varchar(255) not null);
create table itemimages(imageid int unsigned not null, itemid int unsigned not null, primary key(imageid, itemid), 
	constraint fk_imageid_itemimages foreign key(imageid) references image(id) on delete cascade, 
	constraint fk_itemid_itemimages foreign key(itemid) references item(id) on delete cascade);
create table user_details(id int unsigned primary key auto_increment, firstname varchar(50), lastname varchar(50));
create table address(id int unsigned primary key auto_increment, addresstype varchar(20),building varchar(50), city varchar(50), 
	street varchar(50), zipcode varchar(20));
create table useraddress(userid int unsigned, addressid int unsigned, primary key(userid, addressid), 
	constraint fk_userid_address foreign key(userid) references user_details(id) on delete cascade,
	constraint fk_addressid_address foreign key(addressid) references address(id) on delete cascade);
create table bid(id int unsigned primary key auto_increment, amount decimal not null, createdon date not null, endedon date);
create table biddingitems(bidid int unsigned not null unique, buyerid int unsigned not null, primary key(bidid, buyerid), 
	constraint fk_bidid_bidding foreign key(bidid) references bid(id) on delete cascade, 
	constraint fk_buyerid_bidding foreign key(buyerid) references user_details(id) on delete cascade);
create table sellingitems(itemid int unsigned not null unique, sellerid int unsigned not null, primary key(itemid, sellerid), 
	constraint fk_itemid_selling foreign key(sellerid) references bid(id) on delete cascade, 
	constraint fk_userid_selling foreign key(itemid) references user_details(id) on delete cascade);
create table billingdetails(id int unsigned primary key auto_increment, billingtype varchar(20), 
	userid int unsigned not null, constraint fk_userid_bd foreign key(userid) references user_details(id) on delete cascade);
create table creditcard(id int unsigned primary key auto_increment, creditcardnumber varchar(30) not null, 
	expirymonth int not null, expiryyear int not null, billingid int unsigned unique not null, 
	constraint fk_billingid_cc foreign key(billingid) references billingdetails(id) on delete cascade);
create table bankaccount(id int unsigned primary key auto_increment, accountnumber varchar(50) not null, bankname varchar(100), 
	billingid int unsigned unique not null, constraint fk_billingid_ba foreign key(billingid) references billingdetails(id) on delete cascade);



