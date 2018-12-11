启动项目方式
	1.run
	2.mvn spring-boot:run
	
映射前缀为girl的属性到pojo类	
	@Component
	@ConfigurationProperties(prefix = "girl")
	
开发环境和生产环境
	1.分别新建一个.yml文件
		application-dev.yml
		application-prod.yml
		application.yml
			spring:
			  profiles:
				active: prod
	2.采用java -jar 的方式
		mvn install
		进入target目录
		java -jar target/girl-0,0,1....jar --spring.Profiles.active=prod
		
单元测试：	
	采用 mvn clean package 测试所有的
	跳过测试 mvn clean package -Dmaven.test.skip=true