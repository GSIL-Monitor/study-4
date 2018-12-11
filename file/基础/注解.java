常见注解：
	JDK自带注解：@Override @Deprecated  @Suppvisewarnings
		@Override: 重写
		@Deprecated： 过时
		@Suppvisewarnings： 忽略过时方法
		
	常见的第三方注解
		Spring：
			@Autowired
			@Service
			@Repository
		Mybatis：
			@InsertProvider
			@Updateprovider
			@Options
			
	注解的分类：
		1.运行机制分类：
			源码注解：注解只在源码中存在，编译成.class文件就不存在了
			编译时注解: 注解在源码和.class文件中都存在
			运行时注解：在运行阶段还起作用，会影响运行逻辑的注解
		2.来源分类：
			来自JDK的注解
			来自第三方的注解
			自定义注解：
		元注解： 给注解注解的注解
		
		
		
		
1.自定义注解的语法要求
	@interface关键字定义注解
	成员以无参无异常方式声明
	可以用default为成员指定一个默认值
	如果注解只有一个成员，则成员名必须取名为value（），在使用时可以忽略成员名和赋值号
2.注解的注解（元注解）
	
3.使用自定义注解
4.解析注解
		
		
		
		
		
		
		
		
		
		
		
		
		
		