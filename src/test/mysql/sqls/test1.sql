create table account_t
(
    id          int primary key auto_increment,
    name        varchar(50),
    money       int,
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp on update current_timestamp
);

-- 插入一条数据： 朱七   50000
insert into account_t(name, money)
values ('张三', 50000);
insert into account_t(name, money)
values ('李四', 20000);
insert into account_t(name, money)
values ('王五', 10000);
insert into account_t(name, money)
values ('赵六', 10000);
insert into account_t(name, money)
values ('朱七', 50000);