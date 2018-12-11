Runnable方式可以避免 Thread 方式由于
单继承带来的缺陷

Runnable的代码可以被多个线程（Thread实例）
共享， 适合于多个线程处理同一资源的情况


无锁（似无障碍）类的原理： CAS， CPU指令
	

	算法CAS： http://www.cnblogs.com/mjorcen/articles/3966586.aspx
		比较并交换（compare and swep）
			CAS 操作包含三个操作数—— 内存位置（V）、预期原值（A）和新值(B)。
			如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值。
			否则，处理器不做任何操作。无论哪种情况，它都会在 CAS 指令之前返回该位置的值。
			（在 CAS 的一些特殊情况下将仅返回 CAS 是否成功，而不提取当前值。）
			CAS 有效地说明了“我认为位置 V 应该包含值 A；如果包含该值，则将 B 放到这个位置；
			否则，不要更改该位置，只告诉我这个位置现在的值即可。”
		
	CPU指令在： cmpxchg 上操作 ， 使得多个操作在一个cpu上完成， 实现原子性
		
		
无锁类：
	AtomicInteger
	Unsafe
	AtomicReferce
	AtomicStampedReferce  (不重复的， 例如时间戳， 建议使用)
			A	B	A
			1.对A操作，中、，，
			2.A,修改为B
			3.B,修改为A
			1.此时发现是A，以为没变化--->产生问题
			（跟过程无关，只跟结果有关--没有问题， 跟过程有关，产生问题）
	AtomicIntergerArrray
		LeadingZeros （前倒零， 一个32位，前面多少0）
	Atomic
		
		
		
	
JDK并发包：

	控制同步的工具：
		ReentrantLock(可重用， )
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		