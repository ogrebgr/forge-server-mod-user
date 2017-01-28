CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_disabled` tinyint(4) NOT NULL,
  `login_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


CREATE TABLE `user_ext_ids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `ext_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user` (`user`,`type`),
  CONSTRAINT `fk_user_ext_ids_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


CREATE TABLE `user_screen_names` (
  `user` int(11) NOT NULL,
  `screen_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `screen_name_lc` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`user`),
  UNIQUE KEY `i_screen_name_lc` (`screen_name_lc`),
  CONSTRAINT `fk_user_screen_names_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


