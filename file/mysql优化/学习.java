Mysql 链接列和字符串   Concat(id,'_',name,'er')
Mysql 乘以  num*price

使用函数： 
	加上注释，确保后人阅读
	1）文本处理函数
		Mysql 删除多余的空格  Trim(name)
		Mysql 删除左侧多余的空格  LTrim(name)
		Mysql 删除右侧多余的空格  RTrim(name)
		Mysql 转大写   Upper(name)
		Mysql 返回串左边的字符	Left()
		Mysql 返回串的长度	Length()
		Mysql 找出一个串的子串	Locate()
		Mysql 将串转为小写	Lower()
		Mysql 返回右边的字符	Right()
		Mysql 返回串的soundex值 Soundex()
		Mysql 返回子串的字符	SubString()
	2）日期处理函数
		见图
	3）数值处理函数
		Abs()	绝对值函数
		Cos()	余弦值函数
		Exp()	指数值函数
		Mod()	余数值函数
		pi()	圆周率函数
		Rand()	随机数函数
		Sin()	正弦函数
		Sqrt()	平方根函数
		Tan()	正切函数
		
汇总数据
	1）聚集函数
		AVG()	平均值
		Count()	行数
		Max()	最大值
		Min()	最小值
		SUM()	和
	2）聚集不同值
		All()	默认
		DisTinct 不同值
	3）组合聚集函数
		别名
		
分组函数
·	GROUP BY
	1.过滤分组
		HAVING

子查询

联结表
	
	1.内联接
		显式：INNER JOIN	ON
		隐式：，			where 
	2.外联接
		A B C
		1）LEFT JOIN  （LEFT OUTER JOIN）ON
			A B
		2）RIGHT JOIN  （RIGHT OUTER JOIN）ON
			B C
		3）FULL JOIN   （FULL OUTER JOIN）ON
			A B C
	3.交叉联接	
		CROSS JOIN		隐示交叉联接不带ON笛卡尔积
	
		
组合查询
	UNION	（重复行自动取消）  UNION ALL  （出现重复行）
		注意：UNIION的每个查询必须包含相同的列，表达式或聚集函数
		（各个列不需要以相同的次序列出）
		列数据类型必须兼容
	对于组合查询结果进行排序，只能出现一条ORDER BY子句，它必须出现 在最后一条SELEC语句之后
		
		
		
全文本搜索
	并非所有Mysql引擎都支持全文本搜索，MyISAM支持，INNODB不支持

插入
	insert into a（id，name）select price, num from b
删除
	truncate table
		
		
		
		
		
		
		
		