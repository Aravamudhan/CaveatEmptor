--liquibase formatted sql
--changeset amudhan:1
--Initial data
insert into user_details (firstname, lastname) values('James','Bond'),('Jon','Snow'),('Nikola','Tesla'),('Robin','Hood'),('Arya','Stark');
insert into item (name, initialprice,auctionstart,description) values('Kindle e book reader',6000,now(),'An awesome reader'),
	('Steve Jobs',400,now(),'The life of Steve Jobs');
insert into category(name)values('e-reader'),('book'),('ebook'),('hardcover');
insert into image(name, imageurl)values('Book about steve jobs','/resources/images');
insert into bid(amount, createdon) values(6500, now()),(6501, now());
--changeset amudhan:2
insert into billingdetails(billingtype, userid)select 'CREDITCARD' as billingtype, id as userid from user_details;
insert into billingdetails(billingtype, userid)select 'BANKACCOUNT' as billingtype, id as userid from user_details;
insert into category_parent(cid,parentid)values(2,4),(2,3);
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
insert into itemimages(imageid, itemid)select i1.id as imageid, i2.id as itemid from image as i1 join item as i2 on i1.id=i2.id;
insert into address(addresstype, building, city, street, zipcode)
	values ('HOME','12, ABHomes','Chennai','Max street','788039'),('BILLING','12, ABHomes','Chennai','Max street','788039');
insert into useraddress(userid, addressid)select u.id as userid, a.id as addressid from user_details as u
	join address as a on u.id=a.id;
insert into sellingitems(itemid, sellerid)select i.id as itemid, s.id as sellerid from item as i join user_details as s
	on i.id=s.id;
insert into biddingitems(bidid, buyerid)select b.id as bidid, buy.id as buyerid from bid as b join user_details as buy
	on b.id=buy.id;
	
