man ls			man ps			man cd	...

分区： sda1 sda2 sda3...
文件树只有一颗文件系统数

挂载点
	分区 sda1 挂载在 /下， 则存在/下的就存在分区sda1下
	分区 sda2 挂载在 /home下， 则存在home下，下的就存在分区sda1下

Root Directiry

当前用户树， 使用pwd

绝对路径，	/...
相对路径, 	./  ../   ../../
(  cd ： Chang (working) Dir )
返回上一个路径 cd -

copy		cp   拷贝目录  cp -r
move		mv	 mv file ..
rename		mv	 mv filel   file2
				 mv dir1	dir2	#dir2存在，则为移动操作
remove		rm	 rm file
				 rm -r dir
				 

查看文件类型	file  a.txt
查看文件		cat file ...
创建文件		touch	a.txt    &&   >a.txt
创建目录		mkdir	dir

通配符：
	*

打包，压缩
	
.zip
	unzip
	zip -r
	
.tar.gz
	tar  zxvf		x 解压缩
	tar  zcvf		c 压缩

.tar.bz2
	tar jxvf
	tar jcvf


系统每打开一个文件就会打开一个叫文件描述符的东西
	有三个一直打开的文件， 系统就分配三个特殊的文件描述符
	1.三个特殊的文件
		0 --> 	stdin	(标准输入文件)
		1 -->	stdout	(标准输出文件)
		2 -->	stderr	(标准错误输出文件)
	
	2.
		cat a.txt b.txt >c.txt	重写
		cat a.txt >>c.txt	追加	
		ls lll 2>d.java		不存在lll文件 这个错误信息 写进文件d.java中
		标准输入重定向	<
	
	3.标准输入重定向不常用， 一般使用管道线|重定向
		cat a.txt|uniq|grep aaaa|sort
			cat 	连接文件
			sort	排序文本行
			uniq	报道或省略重复行
			grep	打印匹配行
			wc		打印文件中换行符，字，和字节个数
			head	输出文件的第一部分
			tail	输出文件的最后一部分
	
用户，权限
	1.三种权限
		r,读	w，写	x，执行 
		
		对于文件， 操作者分为三种， 
			1.拥有者owner
			2.小组group
			3.其他人world
	2.文件模式
		[root@120 ~]# ls -l a.txt 
		-rw-r--r-- 1 root root 30 Jun 15 20:27 a.txt
			-				普通文件-， 符号链接l, 目录d,	其他...
			1				表示硬链接的数量
			root			owner的名字
			root			group的名字
			30				文件大小
			Jun 15 20:27	最后修改时间
			rw-r--r--		文件模式
				分为三组
					rw-		owner的权限
					r--		group的权限
					r--		world的权限
					
		[root@120 ~]# ls -ld path/
		drwxr-xr-x 2 root root 4096 Feb  2 20:03 path/
						r							w								x（普通文件没有意义，|shell）
		目录	可以查看目录中包含的内容	可以对里面的文件创建删除重命名		cd进入这个目录
		文件	可以查看文件的内容			可以编写文件的内容					./a.sh
		
	3.chomd，chown
		chomd	修改文件权限
			chomd 777 a.txt		一个7对应一个 rwx(7)  rw-(6) -w-(2)
		chown	修改用户权限
		
进程
		1.获取进程号（PID）
			ps aux		ps aux|less
			
				[root@120 ~]# ps aux|less
				USER   PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
				root     1  0.0  0.1  43192  3096 ?        Ss    2017   1:47 /usr/lib/systemd/systemd --switched-root --system --deserialize 21
				root     2  0.0  0.0      0     0 ?        S     2017   0:01 [kthreadd]
				root     3  0.0  0.0      0     0 ?        S     2017   1:46 [ksoftirqd/0]
				root     5  0.0  0.0      0     0 ?        S<    2017   0:00 [kworker/0:0H]

				[root@120 ~]# ps aux|grep redis
				USER   	PID    %CPU %MEM    VSZ   	RSS 	TTY      STAT START   TIME COMMAND
				root    18980  0.0  0.4 	145248  7556 	?        Ssl  May30  18:08 ./redis-server *:7961
				root    27735  0.0  0.0 	112648   968 	pts/0    R+   20:57   0:00 grep --color=auto redis

		2.后台执行
			
		3.kill
			kill 18980		kill -9 18980
			kill HUP
			kill INT
			
	
	
	
	
	















