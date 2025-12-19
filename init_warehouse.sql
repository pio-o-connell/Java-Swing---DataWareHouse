-- This project’s Java code connects to: jdbc:mysql://localhost:3306/warehouse (user=root, password=root)
-- So we create the schema as `warehouse` (lowercase) to match.

DROP DATABASE IF EXISTS `warehouse`;
CREATE DATABASE `warehouse`;
USE `warehouse`;

CREATE TABLE Company(
        Company_ID INT NOT NULL,
        Company_title CHAR(25) NULL,
        PRIMARY KEY(Company_ID)
) ENGINE = InnoDB;

CREATE TABLE Users(
        User_ID INT NOT NULL,
        User_Name CHAR(25) NULL,
        User_Password CHAR(25) NOT NULL,
        Company_ID INT NOT NULL,
        PRIMARY KEY(User_ID)
) ENGINE = InnoDB;

CREATE TABLE Item(
        Item_ID INT NOT NULL AUTO_INCREMENT,
        Company_ID INT NOT NULL,
        quantity INT NULL,
        itemName CHAR(25) NULL,
        Location CHAR(25) NULL,
        PRIMARY KEY(Item_ID,Company_ID)
) ENGINE = InnoDB;

CREATE TABLE History(
        history_id INT NOT NULL AUTO_INCREMENT,
        item_ID INT NOT NULL,
        amount INT NULL,
        description CHAR(25) NULL,
        Supplier CHAR(25) NULL,
        Delivery_Date DATE NULL,
        PRIMARY KEY(history_id)
) ENGINE = InnoDB;

insert into Company(Company_ID,Company_title) values (44008177,"Errickson");

insert into Users(User_ID,User_Name,User_Password,Company_ID) values (100,"Pio ","connuineill123",44008177);

insert into item(Item_ID,Company_ID,quantity,itemName,Location) values (33008177,44008177,1200,"Electric Gear","Cork");
insert into item(Item_ID,Company_ID,quantity,itemName,Location) values (33008178,44008177,600,"Electric Motor","Dublin");
insert into item(Item_ID,Company_ID,quantity,itemName,Location) values (33008179,44008177,600,"Electric Engine","Mayo");
insert into item(Item_ID,Company_ID,quantity,itemName,Location) values (33008180,44008177,600,"Electric Engine","PortLaoise");

insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008177,33008177,100,"Rough rider", "Toshiba", "2008-03-03");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008178,33008177,100,"Freler","Ericksson", "2008-03-04");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008179,33008177,100,"Hells Angel", "Bosch", "2008-03-05");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008180,33008177,100,"Ball", "Krupps", "2008-03-06");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008181,33008177,100,"Hells Angel", "Sony", "2008-03-07");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008182,33008177,100,"Chopper", "Sony", "2008-03-08");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008183,33008177,100, "Slingshot", "Amdahl", "2008-03-09");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008185,33008177,100, " Boss Hoss","Sony", "2008-03-09");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008186,33008177,100, "Cruiser", "Sony", "2008-03-10");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008187,33008177,100, "Heley", "Hoover", "2008-03-11");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008188,33008177,100, "Free Loadr", "IBM",  "2008-03-12");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008189,33008177,100, "Free Rider", "IBM",  "2008-03-13");

insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008190,33008178,100, "HeAngel", "Sony",  "2008-03-03");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008191,33008178,100, "Chopp", "Sony",  "2008-03-04");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008192,33008178,100, "Slingshot", "Amdahl",  "2008-03-05");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008193,33008178,100, " BosHoss","Sony",  "2008-03-06");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008194,33008178,100, "Cruiser", "Sony",  "2008-03-07");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008195,33008178,100,  "Heley", "Hoover" , "2008-03-07");

insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008200,33008179,100, "HeAngel", "Sony",  "2008-03-03");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008201,33008179,100, "Arrow","Sony",  "2008-03-04");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008202,33008179,100, "Slingshot", "Amdahl",  "2008-03-05");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008203,33008179,100, "Cruiser", "Sony",  "2008-03-06");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008204,33008179,100, " Rough Rider","Toyota",  "2008-03-07");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008205,33008179,100, " Sliders","Opel",  "2008-03-08");

insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008206,33008180,100, "Wombat out of hell","Krupps",  "2008-03-03");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008207,33008180,100, "Base Liner", "Sony", "2008-03-04");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008208,33008180,100, "Crusher", "Digital", "2008-03-05");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008209,33008180,100, " Boss Ross", "Kodak", "2008-03-06");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008210,33008180,100, " FreeWheeler", "Richards", "2008-03-07");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date) values (10008211,33008180,100, "Free Spinner","Ericksson", "2008-03-08");
