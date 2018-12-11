
1.后端缓存优化

	1.1.使用protostuff序列化、反序列化

		引入依赖
				
				<!-- https://mvnrepository.com/artifact/com.dyuproject.protostuff/protostuff-core -->
				<dependency>
					<groupId>com.dyuproject.protostuff</groupId>
					<artifactId>protostuff-core</artifactId>
					<version>1.1.3</version>
				</dependency>

				<dependency>
					<groupId>com.dyuproject.protostuff</groupId>
					<artifactId>protostuff-runtime</artifactId>
					<version>1.1.3</version>
				</dependency>
				
				
		测试：
			
			private static RuntimeSchema<PositionVO>   schema = RuntimeSchema.createFrom(PositionVO.class);

			public static void main(String[] args) {
				PositionVO position1 = new PositionVO();
				position1.setId(10);
				position1.setName("北京");
				// 序列化
				byte[] byteArray = ProtostuffIOUtil.toByteArray(position1, schema, 
						//缓存器， 当字节数组过大时， 进行缓冲
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				
				System.err.println(byteArray);
				PositionVO position = schema.newMessage();
				// 反序列化
				ProtostuffIOUtil.mergeFrom(byteArray, position, schema);
				System.err.println(position);
			}

		
	1.2.redis缓存进行优化（需要进行一致性维护）
	
	

2.并发优化(瓶颈出现在网络延迟)
	
					1.update 减库存操作 rowLock
							>
							|
				网络延迟	|	GC处理
							|
							<
					2.insert 购买明细
							>
							|
				网络延迟	|	GC处理
							|
							<
					3.commit/rollback freeLock
	
	修改为：
	
					1.insert 购买明细
							>
							|
				网络延迟	|	GC处理
							|
							<
					2.update 减库存操作 rowLock
							>
							|
				网络延迟	|	GC处理
							|
							<
					3.commit/rollback freeLock
	
3.深度优化：
		方式是：将 事务SQL在MYSQL端执行（存储过程）
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	