INSERT INTO `ims`.`customers` (`firstName`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`itemName`, `itemValue`) VALUES ('dreamcast', '120.00');
INSERT INTO `ims`.`orders` (`orderCost`, `customer_id_fk`) VALUES ('0', '1');
INSERT INTO `ims`.`order_items` (`order_id_fk`,`item_id_fk`) VALUES ('1', '1');
