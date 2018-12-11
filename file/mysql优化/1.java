
Mysql优化

	1.查询优化
	2.索引使用
	3.存储优化
	4.数据库结构优化
	
	5.硬件优化
	6.Mysql缓存
	7.服务器参数（参数非常多）

	存储： MyISAM  和   Innodb

	支持多线程高并发多用户的关系型数据库
	
	1.查询优化
		(1).慢查询
			mysqldumpslow -s c -t 10 /database/mysql/slow-query.log
		(2).解释器
	
	2.索引使用
		(1).B-Tree索引 ***
		(2).R-Tree索引
		(3).Hash索引
		(4).Full-text索引（全文索引  只有char，varchar，text三种）
		
		
		创建索引
			原则：
				较频繁的作为查询条件的字段应该创建索引
				唯一性太差的字段不适合单独创建索引，即便使用频繁（联合索引可以不考虑）
				更新非常频繁的字段不适合创建索引
				不会出现在Where子句中的字段不应该创建索引

		使用索引
			(1).联合索引
			(2).使用or时（必须是两边都是索引才能起作用）
			
			
	3.存储优化
		存储数据时，影响存储速度的主要是索引，唯一校验，一次存储的数据条数等
		(1).MyISAM
				非事务引擎
				提供高速存储和检索，以及全文搜索能力，适合查询频繁的应用
			锁表
		(2).InnoDB
				事务引擎
				如果数据执行大量的INSERT或者UPDATE，应该使用InnoDB表
			行级锁	
			不支持全文检索
		
		(3).MyISAM优化
				1，插入记录时，禁用索引
					在批量插入数据之前禁用索引，在插入完成后再开启索引
					禁用：ALTER TABLE table_name DISABLE KEYS
					开启：ALTER TABLE table_name ENABLE KEYS
				2，禁用唯一性检查
					在批量插入数据之前禁用，在插入完成后再开启
					禁用：SET UNIQUE_CHECKS = 0
					开启：SET UNIQUE_CHECKS = 1
					
				3，批量插入多条数据
					一条比多条快
			
		(4).InnoDB优化
				1，禁用唯一性检查
				
				2，禁用外键检查(开发时不用外键，上线再用)
					禁用：SET foreign_key_checks = 0
					开启：SET foreign_key_checks = 1
				3，禁用自动提交
					禁用：SET autocommit = 0
					开启：SET autocommit = 1
					
	4.数据库结构优化
			
		(1).优化表结构
				1，尽量不用使用null
				2，对于只包含特定类型的字段，可以使用enum，set等符合数据类型
				3，数值型字段的比较比字符串的比较效率高的多
				4，尽量使用TINYINT，SMALLINT,MEDIUM_INT作为整形类型而非INT,如果非负加上UNSIGNED
				5，VARCHAR的长度只分配真正需要的空间
				6，尽量使用TIMESIAMP而非DATETIME
				7，单表不要有太多字段，建议在20以内
				8，合理的加入冗余字段可以提高查询速度
		(2).表拆分
				1，垂直拆分
				2，水平拆分
					动态数据源
					MyCat（数据库中间件）  ****		
		(3).表分区
				range分区
				list预定义列表分区
				hash分区
				key键值分区
		(4).读写分离
				需要解决数据一致性
		(5).数据库集群
				MyCat搭建集群
				
	
	5.硬件优化
			服务器硬件直接决定mysql数据库的运行速度和效率
		内存
		磁盘I/O相关
		CPU
	
	6.mysql缓存
		表改变之后，所有缓存全部消失






