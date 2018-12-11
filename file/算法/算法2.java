
有序数组
	线性查找：从头到后，有一个值大于查找值，停止查询
	二分查找算法：
		思路:
			while(true){
				count = (low + last)>>1;
				if (mingzhong == array[count]) {
					break;
				}else if(low > last){
					count = -1 - last;
					break;
				}else if (mingzhong > array[count]) {  //大
					low = count + 1;
				}else {//小
					last = count - 1;
				}
			}
			return count;
			
			
简单排序：5q	q																																					qqqqqqqqqqqqqqqqqqqqqqqqqqq																																										aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaatttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt
	1.冒泡排序
		思路:	要将最小的数据项放在数组的最开始，并将最大的数据项放在数组的最后。
		int out, i;
		int size = array.length;
		for(out = size - 1; out > 1; out--){
			for (i = 0; i < out; i++) {
				if (array[i] > array[i+1]) {
					array[i] ^= array[i+1];
					array[i+1] ^= array[i];
					array[i] ^= array[i+1];
				}
			}
		}
		
		
	2.选择排序
		int size = array.length;
		for (int small = 0; small < size-1; small++) {
			for (int big = small+1; big < size; big++) {
				if (array[small] > array[big]) {
					array[small] ^= array[big];
					array[big] ^= array[small];
					array[small] ^= array[big];
				}
			}
		}
	
	3.插入排序
		思路： 以局部有序，被标记的对象的左边保持局部有序
		int size = array.length;
		for (int i = 0; i < size; i++) {
			int temp = array[i];
			while(i>0 && array[i-1] >= temp){
				array[i] = array[i-1];
				--i;
			}
			array[i] = temp;
		}
	4.对象排序
		Object ， 不再是基本数据类型
	5.比较
			
			
			
		
数据结构：进行访问受限制，即在特定时刻只有一个数据项可以被读取或者被删除

1.栈
	栈只允许访问一个数据项，即最后插入的数据项，移除这个数据项后才可以访问倒数第二个插入的数据项，以此类推。
				
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
