占位符：
table_name      表名
column_name     列名
pk_name         主键名
fk_name         外键名

创建主键约束：
ALTER TABLE table_name ADD CONSTRAINT pk_name PRIMARY KEY (column_name); 

删除触发器：
DROP TRIGGER trigger_name;

删除外键约束：
ALTER TABLE table_name DROP FOREIGN KEY fk_name;

删除列：
ALTER TABLE table_name DROP COLUMN column_name;

