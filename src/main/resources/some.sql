CREATE TABLE `course`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `course_name` varchar(64) DEFAULT NULL,
    `number`      int(11)     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into course values (1, 'PUA', 0);

CREATE TABLE `user_course`
(
    `user_id` int(11) NOT NULL,
    `course_id`  int(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;