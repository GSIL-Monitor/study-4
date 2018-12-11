启动nginx
	下载nginx ， 解压nginx，
	在解压的目录下，[root@120 nginx]# ./configure --prefix=/usr/local/nginx
	然后			[root@120 nginx]# make && make install
	这时， /usr/local/nginx下就有了四个文件夹	
			conf  	配置文件
			html  	静态文件
			logs  	日志文件
			sbin	进程文件
	启动：			[root@120 nginx]# ./sbin/nginx 
	查看进程：		[root@120 nginx]# netstat -antp
	pkill -9 http 彻底杀死
	kill -9 29390 

信号控制：  官方查看： https://www.nginx.com/resources/wiki/start/topics/tutorials/commandline/
						TERM, INT			Quick shutdown
						QUIT				Graceful shutdown	
						KILL				Halts a stubborn process
						HUP					Configuration reload
											Start the new worker processes with a new configuration
											Gracefully shutdown the old worker processes
						USR1				Reopen the log files
						USR2				Upgrade Executable on the fly
						WINCH				Gracefully shutdown the worker processes
	[root@120 nginx]# ps aux | grep nginx
	root     20716  0.0  0.0  24944   776 ?        Ss   13:09   0:00 nginx: master process ./sbin/nginx
	nobody   20717  0.0  0.0  25364  1752 ?        S    13:09   0:00 nginx: worker process
	root     20807  0.0  0.0 112648   964 pts/0    R+   13:22   0:00 grep --color=auto nginx
	使用：
		kill  [信号量] [进程号]
		[root@120 nginx]# kill -INT 20716
		[root@120 nginx]# kill -HUP 20716	重读配置
		[root@120 ~]# /usr/local/nginx/sbin/nginx -s reload    重启nginx
		

		日志： 
			第一步：开启， 去掉#
				
					#log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
					#			'$status $body_bytes_sent "$http_referer" '
					#			'"$http_user_agent" "$http_x_forwarded_for"';
			第二步： 在需要的项目下加log
					 #access_log  logs/host.access.log  main;
		
			[root@120 ~]# date -d yesterday +%Y%m%d
			20180319
			写shell脚本
			[root@120 ~]# cd /data/
			[root@120 ~]# vim nginx-run-log.sh
				
					#nginx-log-everyday
					
					LOGPATH=/usr/local/nginx/logs/our-test.log
					BasePath=/usr/local/nginx/logs
					backPath=$BasePath/our-test.log.$(date -d yesterday +%Y%m%d%H%M)

					#echo $backPath

					mv $LOGPATH $backPath
					touch $LOGPATH
					kill -USR1 cat /use/local/nginxlogs/nginx.pid
				
			[root@120 data]# crontab -e
				*/1 * * * * sh /data/nginx.log.sh




1.nginx命令行参数
			
		-c </path/to/config> 为 Nginx 指定一个配置文件，来代替缺省的。
		-t 不运行，而仅仅测试配置文件。nginx 将检查配置文件的语法的正确性，并尝试打开配置文件中所引用到的文件。
		-v 显示 nginx 的版本。
		-V 显示 nginx 的版本，编译器版本和配置参数。
			
			ep：
				[root@120 ~]# cd /usr/local/nginx/sbin/
				[root@120 sbin]# ./nginx -v
				nginx version: nginx/1.10.3
				[root@120 sbin]# ./nginx -t
				nginx: the configuration file /usr/local/nginx/conf/nginx.conf syntax is ok
				nginx: configuration file /usr/local/nginx/conf/nginx.conf test is successful
				[root@120 sbin]# ./nginx -V
				nginx version: nginx/1.10.3
				built by gcc 4.8.5 20150623 (Red Hat 4.8.5-16) (GCC) 
				configure arguments: --prefix=/usr/local/nginx
				[root@120 sbin]# ./nginx -c /usr/local/nginx/conf/nginx.conf
				nginx: [emerg] bind() to 0.0.0.0:80 failed (98: Address already in use)
				nginx: [emerg] bind() to 0.0.0.0:80 failed (98: Address already in use)
				nginx: [emerg] bind() to 0.0.0.0:80 failed (98: Address already in use)
				nginx: [emerg] bind() to 0.0.0.0:80 failed (98: Address already in use)
				nginx: [emerg] bind() to 0.0.0.0:80 failed (98: Address already in use)
			
2.nginx控制信号
	可以使用信号系统来控制主进程。默认，nginx 将其主进程的 pid 写入到 /usr/local/nginx/logs/nginx.pid 文件中。通过传递参数给 ./configure 或使用 pid 指令，来改变该文件的位置。
		
	主进程可以处理以下的信号：	
		TERM, INT				快速关闭
		QUIT					从容关闭
		HUP						重载配置，用新的配置开始新的工作进程，从容关闭旧的工作进程
		USR1					重新打开日志文件
		USR2					平滑升级可执行程序。
		WINCH					从容关闭工作进程，
	
	尽管你不必自己操作工作进程，但是，它们也支持一些信号：
		TERM, INT				快速关闭
		QUIT					从容关闭
		USR1					重新打开日志文件
 
	[root@120 nginx]# grep pid /usr/local/nginx/conf/nginx.conf
	#pid        logs/nginx.pid;
			
	kill -信号类型(HUP|TERM|QUIT) cat /usr/local/nginx/logs/nginx.pid 		
		
	[[root@120 nginx]# kill -HUP `cat /usr/local/nginx/logs/nginx.pid`
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			




