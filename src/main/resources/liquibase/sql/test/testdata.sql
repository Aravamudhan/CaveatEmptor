--liquibase formatted sql
--changeset amudhan:1
--Initial data
insert into category(name)values('book'),('electronics');
insert into category(name, parentid)values('Paperback',1),('ebook',1),('hardcover',1),('phone',2),('mobile phone',6);
insert into user_details (firstname, lastname, usertype) values('James','Bond','BUYER'),('Jon','Snow','SELLER'),('Nikola','Tesla','BUYER'),
	('Robin','Hood','SELLER'),('Arya','Stark','BUYER');
insert into user_details (firstname, lastname, usertype) values ('Rob','Stark','SELLER'),('Jon','Aryn','BUYER');
insert into item (name, initialprice,description, sellerid, categoryid) values('Kindle e book reader', 6000, 'An awesome reader', 2, 2),
	('Steve Jobs', 400, 'The life of Steve Jobs', 4, 1),('Dell XPS',5000,'A high end laptop',4,2);
insert into item (name, initialprice,description, sellerid, categoryid) values('Lenovo', 12000, 'A good phone', 2, 2);
insert into image(name, imageurl, itemid)values('Book about steve jobs','/resources/images/thelifeofjobs.jpg',1),
	('Dell laptop','/resources/images/dellxps.jpg',3),('Kindle ebook reader','/resources/images/kindleebookreader.jpg',2);
insert into address(addresstype, building, city, street, zipcode, userid)
	values ('HOME','12, ABHomes','Chennai','Max street','11',1),('BILLING','33, Ferret appartment','Mumbai','Maximum street','22',1), 
			('BILLING','436, EE Homes','Engineer avenue Chennai','Supreme street','12',2),('HOME','46, EE Homes','Engineer avenue Chennai','Supreme street','12',2),
            ('BILLING','1B, A Apartments','AB avenue Delhi','XZ street','89',3),('HOME','343, JI Homes','Spacefeast avenue Chennai','Super muggle street','77',3),
            ('BILLING','36, Plot 78','May avenue Mumbai','KS','56',4),('HOME','36, Plot 78','May avenue Mumbai','KS','56',4),
            ('BILLING','432, First floor, Victoria gated community','XP avenue Kochin','KI street','34',5),('HOME','432, First floor, Victoria gated community','XP avenue Kochin','KI street','34',5);
insert into bid(amount, createdon, itemid, bidderid) values(6500, now(), 1, 1),(6501, now(), 1, 2),(6301, now(), 1, 3),(6302, now(), 1, 3),(300, now(), 2, 4),
	(301, now(), 2, 5),(350, now(), 2, 1);
set @accountnumber='123';
set @count=4;
set @bankname='Bank1';
insert into bankaccount(accountnumber, bankname, userid)select concat(@accountnumber,@count:=@count+1) as accountnumber, 
	concat(@bankname,@count:=@count+1) as bankname, id as userid from user_details;
set @ccnumber='321';
set @ccount='4';
set @exmonth='1';
set @exyear='2018';
insert into creditcard(creditcardnumber, expirymonth, expiryyear, userid)select concat(@ccnumber,@ccount:=@count+1) as creditcardnumber, 
	(@exmonth:=@exmonth+1)as expirymonth,(@exyear:=@exyear+1)as exyear, id as userid from user_details;