/* define the schemas. */

/* t_userテーブル */
DROP TABLE t_user;
CREATE TABLE t_user(
    userid varchar(4),
    username varchar(20),
    birthday DATE,
    address varchar(256),
    tel varchar(11),
    password varchar(60),
    status varchar(4),
    updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    constraint pk_t_user_userid primary key (userid)
);

/* t_roleテーブル */
DROP TABLE t_role;
CREATE TABLE t_role(
    userid varchar(4),
    role varchar(4),
    constraint pk_t_role_userid_role primary key (userid,role)
);