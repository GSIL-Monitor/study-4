线程：
	进程内的执行单元
	
	
			start                      结束
	new	---------->    runnable     ---------> terminated
					>   | >     | >
			同步块	|  w| |		| |-----------
			sysc	|  a| |		|---------|  |notify
	blocked<---------- i| |notify	 wait |  |
					   t| |               |  |
					    < |               <  |
					  waiting             timed.waiting
					  无限等待             有时间限等待
					  
					  
					  
线程的基本操作：
	join： 等待线程结束
	yeild：谦让


守护线程：
	在后台默默地完成一些系统的服务，比如GC，JIT线程
	
线程优先级：
	1,5,10 默认5
	
基本的线程同步操作：
	sysc:
		加对象： 给指定对象加锁， 获取对象的锁
		加方法： 相当于当前实例加锁，获取当前实例的锁
		静态：相当于类加锁，获取当前类的锁
	object.wait(), Object.notify()
	
	
	
	
	
	
	
	
	


