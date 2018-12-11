无锁类的原理：
	CAS（比较和交换）：包含3个参数（V,E,N），V表示要更新的变量，E表示期望值，N表示新值
	CPU指令：指令层面为原子性，即1条CPU指令


无锁类的使用：
	AtomicInteger:
	Unsafe: 非安全的操作
	AtomicReference:
	AtomicStampedReference:（加上唯一表示，比如时间戳， 例如：充钱，只能充一次，不会因为你消费完了再给你充一次， 即CAS检查不仅仅检查期望值，还检查唯一性标识）
	AtomicIntegerArray:
	AtomicIntegerFieldUpdater:


无锁算法详解