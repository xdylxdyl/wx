-- ----------------------------
-- Table structure for `decorate`
-- ----------------------------
-- DROP TABLE IF EXISTS `decorate`;
CREATE TABLE `decorate` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `serial_id` varchar(45) NOT NULL  ,  
    `user_id` varchar(45) NOT NULL  ,  
    `user_name` varchar(45) NOT NULL  ,  
    `user_mobile` varchar(45) NOT NULL  ,  
    `user_wx_id` varchar(500) NOT NULL  ,  
    `user_wx_name` varchar(45) NOT NULL  ,  
    `room_id` bigint NOT NULL  ,  
    `room_name` VARCHAR(45) NOT NULL  ,  
    `building_id` bigint NOT NULL  ,  
    `building_name` VARCHAR(45) NOT NULL  ,  
    `vender_id` bigint NOT NULL  ,  
    `vender_name` VARCHAR(45) NOT NULL  ,  
    `chargerId` bigint NOT NULL  ,  
    `charger_name` VARCHAR(45) NOT NULL  ,  
    `charger_mobile` VARCHAR(45) NOT NULL  ,  
    `publics_id` bigint NOT NULL  ,  
    `publics_name` varchar(45) NOT NULL  ,  
    `drawing_count` varchar(45) NOT NULL  ,  
    `status` varchar(45) NOT NULL  ,  
    `expect_start_date` varchar(45) NOT NULL  ,  
    `expect_check_date` varchar(45) NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





