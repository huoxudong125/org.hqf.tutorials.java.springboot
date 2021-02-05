-- 初始化插入一些博客信息数据.
INSERT INTO test.t_test_blog VALUES ('1', '张三', '这是内容', '2019-03-01 00:41:01', 'Spring从入门到精通', 'https://baidu.com', '1', 'tom', '2019-03-01 00:41:33', '2019-03-01 00:41:36');
INSERT INTO test.t_test_blog VALUES ('2', '李四', '这是Mybatis的内容', '2019-03-01 00:41:01', 'Mybatis基础', 'https://qq.com', '2', 'jack', '2019-03-01 00:41:33', '2019-03-01 00:41:36');
commit;