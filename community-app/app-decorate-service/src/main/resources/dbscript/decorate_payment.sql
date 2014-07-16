-- ----------------------------
-- Table structure for `decorate_payment`
-- ----------------------------
-- DROP TABLE IF EXISTS `decorate_payment`;
CREATE TABLE `decorate_payment` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `name` varchar(45) NOT NULL  ,  
    `amount` varchar(45) NOT NULL  ,  
    `status` varchar(45) NOT NULL  ,  
    `type` varchar(45) NOT NULL  ,  
    `remark` varchar(500)   ,  
    `decorate_id` bigint NOT NULL  ,  
    `decorate_serial_id` bigint NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





