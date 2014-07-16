-- ----------------------------
-- Table structure for `decorate_vender`
-- ----------------------------
-- DROP TABLE IF EXISTS `decorate_vender`;
CREATE TABLE `decorate_vender` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `vender_id` bigint NOT NULL  ,  
    `vender_name` varchar(45) NOT NULL  ,  
    `is_have_license` TINYINT NOT NULL  ,  
    `legal_name` varchar(45) NOT NULL  ,  
    `legal_id_number` varchar(45) NOT NULL  ,  
    `legal_mobile` varchar(45) NOT NULL  ,  
    `contact_name` varchar(45) NOT NULL  ,  
    `contact_id_number` varchar(45) NOT NULL  ,  
    `contact_mobile` VARCHAR(45) NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





