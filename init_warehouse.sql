-- Add Notes field to Item and history tables
ALTER TABLE Item ADD COLUMN Notes VARCHAR(200);
ALTER TABLE history ADD COLUMN Notes VARCHAR(200);
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
        Notes VARCHAR(200) NULL,
        PRIMARY KEY(Item_ID,Company_ID)
) ENGINE = InnoDB;


CREATE TABLE History(
        history_id INT NOT NULL AUTO_INCREMENT,
        item_ID INT NOT NULL,
        amount INT NULL,
        description CHAR(25) NULL,
        Supplier CHAR(25) NULL,
        Delivery_Date DATE NULL,
        Notes VARCHAR(200) NULL,
        PRIMARY KEY(history_id)
) ENGINE = InnoDB;


-- Consistent, realistic sample data
insert into Company(Company_ID,Company_title) values (1001, "Green Thumb Ltd");

insert into Users(User_ID,User_Name,User_Password,Company_ID) values (2001, "Daisy Gardener", "growmore", 1001);

insert into item(Item_ID,Company_ID,quantity,itemName,Location,Notes) values (3001,1001,250,"Tomato Seeds","Greenhouse","Heirloom variety for spring planting");
insert into item(Item_ID,Company_ID,quantity,itemName,Location,Notes) values (3002,1001,100,"Garden Shovel","Tool Shed","Stainless steel, long handle");
insert into item(Item_ID,Company_ID,quantity,itemName,Location,Notes) values (3003,1001,75,"Rose Bush","Nursery","Red climbing roses, 2-year-old plants");
insert into item(Item_ID,Company_ID,quantity,itemName,Location,Notes) values (3004,1001,40,"Compost Bag","Compost Area","Organic compost, 50L bags");


-- Tomato Seeds
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4001,3001,100,"Seed delivery","WireMakers","2025-03-10","High-germination batch");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4002,3001,50,"Planted in greenhouse","Green Thumb Ltd","2025-03-15","Planted in raised beds");

-- Garden Shovel
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4003,3002,40,"Tool shipment","PipeWorks","2025-04-01","New shovels for spring");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4004,3002,10,"Issued to staff","Green Thumb Ltd","2025-04-05","Assigned to garden team");

-- Rose Bush
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4005,3003,25,"Received from nursery","WireMakers","2025-05-10","Healthy, well-rooted plants");
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4006,3003,10,"Planted in flower bed","Green Thumb Ltd","2025-05-12","Planted along fence");

-- Compost Bag
insert into history(history_id,item_ID,amount,description,Supplier,Delivery_Date,Notes) values (4007,3004,40,"Compost delivery","PipeWorks","2025-06-01","Organic compost, spring batch");
