-- 创建数据库表所在的模式 schema.
CREATE SCHEMA test;
commit;

-- 在 test 模式下创建数据库表.
DROP TABLE IF EXISTS test.t_test_blog;
CREATE TABLE test.t_test_blog (
    c_id varchar(32) NOT NULL,
    c_author varchar(255),
    c_content varchar(255),
    dt_publish_time timestamp(6) NULL,
    c_title varchar(255),
    c_url varchar(255),
    n_status int,
    c_create_user varchar(255),
    dt_create_time timestamp(6) NULL,
    dt_update_time timestamp(6) NULL,
    constraint pk_test_blog primary key(c_id)
);
commit;