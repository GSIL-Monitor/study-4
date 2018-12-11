跨域的产生原因:
	1.浏览器限制
	2.跨域（ip,端口，，，等）
	3.XHR（XMLHttpRequest）请求
	
	
	
解决思路：
		浏览器
		  |
		XHR ----->jSONP
		  |
		跨域----->被调用方允许跨域
		  |
		  |------>调用方隐藏跨域
		  
	1.浏览器解决	
		修改参数，使浏览器不做校验
		
	2.JSONP解决	  
		JSONP（采用的是约定，约定参数为callbask，可以修改）的实现原理：（后台需要变更 代码， 返回script代码， 而不是json字符串）
			前台发送的是一个script请求， 带有一个callback参数
			后台接收到callbask参数，就知道返回的是javascript代码， 而不是json字符串
			
			
		JSONP的弊端：
			服务器需要改动代码
			只支持GET方法
			发送的不是XHR请求
	
	3.跨域解决方案
		3.1被调用方
			调用方的浏览器---->被调用方的服务器---->被调用方的应用服务器
					<										|
					|										|
					|---------------------------------------|
			
			增加响应头：
				在 被调用方的服务器 ， 被调用方的应用服务器 上都可以增加
				
		采用Filter
				String origin = request.getHeader("Origin");
				if (StringUtils.isNotBlank(origin)) {
					response.addHeader("Access-Control-Allow-Origin", origin);
				}
				
				String headers = request.getHeader("Access-Control-Request-Headers");
				if (StringUtils.isNotBlank(headers)) {
					response.addHeader("Access-Control-Allow-Headers", origin);
				}
				response.addHeader("Access-Control-Allow-Methods", "*");
				response.addHeader("Access-Control-Max-Age", "3600"); 
				response.addHeader("Access-Control-Allow-Credentials", "true"); 
	
		采用nginx方式
				server{
					listen 80;
					location /{
						proxy_pass http:127.0.0.1:8080;
						
						add_header Access-Control-Allow-Methods *;
						add_header Access-Control-Max-Age 3600;
						add_header Access-Control-Allow-Credentials true;
						add_header Access-Control-Allow-Headers $http_origin;
						add_header Access-Control-Allow-Headers $http_access-control-allow-headers;
						
						if ($request_method = OPTIONS){
							return 200;
						}
					
				}
		
		采用apach解决
		
		采用Spring框架解决： 
			加注解@CrossOrigin
			@CrossOrigin(allowCredentials="true")

				
		3.2调用方
		    调用方的浏览器---->被调用方的服务器---->应用服务器
		  
		  nginx ： 采用方向代理方案
		  
		  
		  
		  
简单请求和非简单请求：
	简单请求：
		GET，HEAD，POST
		请求header里面
			无自定义请求头
			Content—type是：text/plain， multipart/form-data,  application/x-www-form-urlencoded
	
	非简单请求：
		put,delete...
		发送json格式的ajax请求
		带自定义头的ajax请求
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  