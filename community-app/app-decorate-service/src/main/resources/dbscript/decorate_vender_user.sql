-- ----------------------------
-- Table structure for `decorate_vender_user`
-- ----------------------------
-- DROP TABLE IF EXISTS `decorate_vender_user`;
CREATE TABLE `decorate_vender_user` (
    `id` bigint NOT NULL   AUTO_INCREMENT ,  
    `vender_id` bigint NOT NULL  ,  
    `vender_name` varchar(45) NOT NULL  ,  
    `user_name` varchar(45) NOT NULL  ,  
    `user_id_number` varchar(45) NOT NULL  ,  
    `user_mobile` varchar(45) NOT NULL  ,  
    `user_mobile1` varchar(45) NOT NULL  ,  
    `user_mobile2` varchar(45) NOT NULL  ,  
    `user_email` varchar(45) NOT NULL  ,  
    `user_qq` varchar(45) NOT NULL  ,  
    `update_at` bigint NOT NULL  ,  
    `create_at` bigint NOT NULL  ,  
    `update_by` bigint NOT NULL  ,  
    `create_by` bigint NOT NULL  ,  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





