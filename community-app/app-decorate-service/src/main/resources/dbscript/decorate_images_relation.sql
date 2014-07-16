-- ----------------------------
-- Table structure for `decorate_images_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `decorate_images_relation`;
CREATE TABLE `decorate_images_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `decorate_id` varchar(45) NOT NULL  ,  
    `image_id` varchar(45) NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





