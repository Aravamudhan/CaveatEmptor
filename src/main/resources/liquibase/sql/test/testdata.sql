--liquibase formatted sql
--changeset amudhan:1
--Initial data
insert into category(name)values('e-reader'),('book'),('ebook'),('hardcover');
insert into user_details (firstname, lastname, usertype) values('James','Bond','BUYER'),('Jon','Snow','SELLER'),('Nikola','Tesla','BUYER'),
	('Robin','Hood','SELLER'),('Arya','Stark','BUYER');
insert into item (name, initialprice,description, sellerid) values('Kindle e book reader', 6000, 'An awesome reader', 2),
	('Steve Jobs', 400, 'The life of Steve Jobs', 3);
insert into image(name, imageurl, itemid)values('Book about steve jobs','/resources/images',1);
insert into address(addresstype, building, city, street, zipcode, userid)
	values ('HOME','12, ABHomes','Chennai','Max street','788039',1),('BILLING','12, ABHomes','Chennai','Max street','788039',4);
insert into bid(amount, createdon, itemid, bidderid) values(6500, now(), 1, 4),(6501, now(), 1, 1);
insert into billingdetails(billingtype, userid)select 'CREDITCARD' as billingtype, id as userid from user_details;
insert into billingdetails(billingtype, userid)select 'BANKACCOUNT' as billingtype, id as userid from user_details;
set @accountnumber='123';
set @count=4;
set @bankname='Bank1';
insert into bankaccount(accountnumber, bankname, billingid)select concat(@accountnumber,@count:=@count+1) as accountnumber, 
	concat(@bankname,@count:=@count+1) as bankname, id as billingid from billingdetails where billingtype='BANKACCOUNT';
set @ccnumber='321';
set @ccount='4';
set @exmonth='1';
set @exyear='2018';
insert into creditcard(creditcardnumber, expirymonth, expiryyear, billingid)select concat(@ccnumber,@ccount:=@count+1) as creditcardnumber, 
	(@exmonth:=@exmonth+1)as expirymonth,(@exyear:=@exyear+1)as exyear, id as billingid from billingdetails where billingtype='CREDITCARD';
insert into category(name)values('e-reader'),('book'),('ebook'),('hardcover'),('phone');
insert into user_details (firstname, lastname, usertype) values ('Rob','Stark','SELLER'),('Jon','Aryn','BUYER');
insert into item (name, initialprice,description, sellerid, categoryid) values('Lenovo', 12000, 'A good phone', 2, 9);