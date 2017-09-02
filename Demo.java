package demo;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Demo {
	int []array = new int[]{1,9,4,7,6,2,3,0,5,8};
	
	
	/**
	 * 冒泡排序
	 */
	@Test
	public void test01(){
		 System.out.println("排序前-----------------------"+Arrays.toString(array));
		 for(int i=0;i<array.length-1;i++){
			 for(int j=0;j<array.length-i-1;j++){
				 if(array[j]>array[j+1]){
					 int temp = array[j];
					 array[j] = array[j+1];
					 array[j+1] = temp;
				 }
			 }
		 }
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	 }
	
	
	
	/**
	 * 选择排序
	 */
	@Test
	public void test02(){
		 System.out.println("排序前-----------------------"+Arrays.toString(array));
		 for(int i=0;i<array.length;i++){
			 int flag = i;
			 for(int j=i;j<array.length;j++){
				 if(array[j]>array[flag]){
					 flag = j;
				 }
			 }
			 if(flag!=i){
				 int temp = array[flag];
				 array[flag] = array[i];
				 array[i] = temp;
			 }
		 }
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * 插入排序
	 */
	@Test
	public void test03(){
		 System.out.println("排序前-----------------------"+Arrays.toString(array));
		 for(int i=1;i<array.length;i++){
			 int key = i-1;
			 int temp = array[i];
			 while(key>=0&&array[key]>temp){
				 array[key+1]=array[key];
				 key--;
			 }
			 array[key+1]=temp;
		 }
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	}
	
	
	/**
	 * 希尔排序（在插入排序的基础上分组排序）
	 */
	@Test
	public void test04(){
		System.out.println("排序前-----------------------"+Arrays.toString(array));
		int step = array.length/2;
		while(step>0){
			for(int k=0;k<step;k++){
				 for(int i=k+step;i<array.length;i+=step){
					 int key = i-step;
					 int temp = array[i];
					 while(key>=k&&array[key]>temp){
						 array[key+step]=array[key];
						 key-=step;
					 }
					 array[key+step]=temp;
				 }
			}
			step/=2;
		}
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * 归并排序
	 */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }
    
    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }
	@Test
	public void test05(){
		System.out.println("排序前-----------------------"+Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * 堆排序
	 * 
	 */
	 public static void swap(int[] data, int i, int j) {  
	        if (i == j) {  
	            return;  
	        }  
	        data[i] = data[i] + data[j];  
	        data[j] = data[i] - data[j];  
	        data[i] = data[i] - data[j];  
	 } 
	 public static void createMaxdHeap(int[] data, int lastIndex) {  
	        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
	            // 保存当前正在判断的节点  
	            int k = i;  
	            // 若当前节点的子节点存在  
	            while (2 * k + 1 <= lastIndex) {  
	                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点  
	                int biggerIndex = 2 * k + 1;  
	                if (biggerIndex < lastIndex) {  
	                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex  
	                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
	                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值  
	                        biggerIndex++;  
	                    }  
	                }  
	                if (data[k] < data[biggerIndex]) {  
	                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k  
	                    swap(data, k, biggerIndex);  
	                    k = biggerIndex;  
	                } else {  
	                    break;  
	                }  
	            }  
	        }  
	    } 
	 @Test
	 public void test06(){
		 System.out.println("排序前-----------------------"+Arrays.toString(array));
		 for (int i = 0; i < array.length; i++) {  
	            createMaxdHeap(array, array.length - 1 - i);  
	            swap(array, 0, array.length - 1 - i);             
	        }  
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	 }
	 
	 
	 
	 /**
	  * 快速排序
	  */
	 private static int partition(int[] array, int beg, int end) {  
	        int first = array[beg];  
	        int i = beg, j = end;  
	        while (i < j) {  
	            while (array[i] <= first && i < end) {  
	                i++;  
	            }  
	            while (array[j] > first && j >= beg) {  
	                j--;  
	            }  
	            if (i < j) {  
	                array[i] = array[i] + array[j];  
	                array[j] = array[i] - array[j];  
	                array[i] = array[i] - array[j];  
	            }  
	        }  
	        if (j != beg) {  
	            array[j] = array[beg] + array[j];  
	            array[beg] = array[j] - array[beg];  
	            array[j] = array[j] - array[beg];  
	        }  
	        return j;  
	    }  
		 private static void quickSort(int[] array,int beg,int end){  
		        if(beg >= end || array == null)  
		            return;  
		        int p = partition(array, beg, end);  
		        quickSort(array, beg, p-1);  
		        quickSort(array, p+1, end);  
		    }
	 @Test
	 public void test07(){
		 System.out.println("排序前-----------------------"+Arrays.toString(array));
		 quickSort(array,0,array.length-1);
		 System.out.println("排序后-----------------------"+Arrays.toString(array));
	 }
	 
	 
	 /**
	  * 折半查找法
	  */
	 public static boolean Search(int k,int []data) {  
	        int left = 0;// 左边界变量  
	        int right = 19;// 右边界变量  
	        int middle;// 中位数变量  
	        while (left <= right) {  
	            middle = (left + right) / 2;  
	            if (k < data[middle]) {  
	                right = middle - 1;// 查找前半段  
	            } else if (k > data[middle]) {  
	                left = middle + 1;// 查找后半段  
	            } else if (k == data[middle]) {  
	                System.out.println("Data[" + middle + "] = " + data[middle]);  
	                return true;  
	            }  
	            count++;  
	        }  
	        return false;  
	    } 
	 public static int count = 1;
	 @Test
	 public void test08(){
		   int Max = 20;  
		    // 数据数组源  
		    int data[] = { 12, 16, 19, 22, 25, 32, 39, 39, 48, 55, 57,58,63, 68, 69, 70, 78, 84, 88, 90, 97 };  
		    // 计数器   		     
		        System.out.println("请输入您要查找的数字：");  
		        Scanner sc = new Scanner(System.in);  
		        int KeyValue = sc.nextInt();  
		        // 调用折半查找  
		        if (Search(KeyValue,data)) {  
		            // 输出查找次数  
		            System.out.println("共查找了" + count + "次");  
		        } else {  
		            // 输出没有找到数据  
		            System.out.println("抱歉,数据数组源中找不到您输入的数字");  
		        } 
	 }
	
}
