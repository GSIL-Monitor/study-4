IOC: 控制反转
	控制反转是应用本身不负责依赖对象的创建及维护，依赖对象的创建和维护是由外部容器负责的。这样控制权就由应用转移到了外部容器，
控制权的转移就是所谓反转

DI：依赖注入
	依赖注入：在运行期，由外部容器动态的将依赖对象注入到组件
	
	
	刚开始， 我们采用new的方式在应用本身进行创建。
	
	
	使用spring，不需要手动控制事务