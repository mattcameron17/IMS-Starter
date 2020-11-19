drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    `order_id_fk` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `itemName` VARCHAR(40) NULL DEFAULT NULL,
    `itemValue` DOUBLE(200,2) NULL DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `orderCost` DOUBLE(200,2) NULL DEFAULT NULL,
    `customer_id_fk` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`customer_id_fk`) REFERENCES customers(`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`order_items_id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id_fk` INT(11) NULL DEFAULT NULL,
    `item_id_fk` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`order_items_id`),
    FOREIGN KEY (`order_id_fk`) REFERENCES orders(`order_id`),
    FOREIGN KEY (`item_id_fk`) REFERENCES items(`item_id`)
);


