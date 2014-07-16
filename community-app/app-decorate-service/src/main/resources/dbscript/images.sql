-- ----------------------------
-- Table structure for `images`
-- ----------------------------
-- DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `name` varchar(45) NOT NULL  ,  
    `original_path` varchar(45) NOT NULL  ,  
    `big_path` varchar(45) NOT NULL  ,  
    `middle_path` varchar(45) NOT NULL  ,  
    `small_path` varchar(45) NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





