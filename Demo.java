package demo;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Demo {
	int []array = new int[]{1,9,4,7,6,2,3,0,5,8};
	
	
	/**
	 * ð������
	 */
	@Test
	public void test01(){
		 System.out.println("����ǰ-----------------------"+Arrays.toString(array));
		 for(int i=0;i<array.length-1;i++){
			 for(int j=0;j<array.length-i-1;j++){
				 if(array[j]>array[j+1]){
					 int temp = array[j];
					 array[j] = array[j+1];
					 array[j+1] = temp;
				 }
			 }
		 }
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	 }
	
	
	
	/**
	 * ѡ������
	 */
	@Test
	public void test02(){
		 System.out.println("����ǰ-----------------------"+Arrays.toString(array));
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
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * ��������
	 */
	@Test
	public void test03(){
		 System.out.println("����ǰ-----------------------"+Arrays.toString(array));
		 for(int i=1;i<array.length;i++){
			 int key = i-1;
			 int temp = array[i];
			 while(key>=0&&array[key]>temp){
				 array[key+1]=array[key];
				 key--;
			 }
			 array[key+1]=temp;
		 }
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	}
	
	
	/**
	 * ϣ�������ڲ�������Ļ����Ϸ�������
	 */
	@Test
	public void test04(){
		System.out.println("����ǰ-----------------------"+Arrays.toString(array));
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
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * �鲢����
	 */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// ��ָ��
        int j = mid + 1;// ��ָ��
        int k = 0;
        // �ѽ�С�������Ƶ���������
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // �����ʣ�������������
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // ���ұ߱�ʣ�������������
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // ���������е�������nums����
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }
    
    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // ���
            mergeSort(a, low, mid);
            // �ұ�
            mergeSort(a, mid + 1, high);
            // ���ҹ鲢
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }
	@Test
	public void test05(){
		System.out.println("����ǰ-----------------------"+Arrays.toString(array));
		mergeSort(array, 0, array.length - 1);
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	}
	
	
	
	/**
	 * ������
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
	            // ���浱ǰ�����жϵĽڵ�  
	            int k = i;  
	            // ����ǰ�ڵ���ӽڵ����  
	            while (2 * k + 1 <= lastIndex) {  
	                // biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
	                int biggerIndex = 2 * k + 1;  
	                if (biggerIndex < lastIndex) {  
	                    // �����ӽڵ���ڣ������ʱbiggerIndexӦ�õ��� lastIndex  
	                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
	                        // �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
	                        biggerIndex++;  
	                    }  
	                }  
	                if (data[k] < data[biggerIndex]) {  
	                    // ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ��������biggerIndexֵ��ֵ��k  
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
		 System.out.println("����ǰ-----------------------"+Arrays.toString(array));
		 for (int i = 0; i < array.length; i++) {  
	            createMaxdHeap(array, array.length - 1 - i);  
	            swap(array, 0, array.length - 1 - i);             
	        }  
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	 }
	 
	 
	 
	 /**
	  * ��������
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
		 System.out.println("����ǰ-----------------------"+Arrays.toString(array));
		 quickSort(array,0,array.length-1);
		 System.out.println("�����-----------------------"+Arrays.toString(array));
	 }
	 
	 
	 /**
	  * �۰���ҷ�
	  */
	 public static boolean Search(int k,int []data) {  
	        int left = 0;// ��߽����  
	        int right = 19;// �ұ߽����  
	        int middle;// ��λ������  
	        while (left <= right) {  
	            middle = (left + right) / 2;  
	            if (k < data[middle]) {  
	                right = middle - 1;// ����ǰ���  
	            } else if (k > data[middle]) {  
	                left = middle + 1;// ���Һ���  
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
		    // ��������Դ  
		    int data[] = { 12, 16, 19, 22, 25, 32, 39, 39, 48, 55, 57,58,63, 68, 69, 70, 78, 84, 88, 90, 97 };  
		    // ������   		     
		        System.out.println("��������Ҫ���ҵ����֣�");  
		        Scanner sc = new Scanner(System.in);  
		        int KeyValue = sc.nextInt();  
		        // �����۰����  
		        if (Search(KeyValue,data)) {  
		            // ������Ҵ���  
		            System.out.println("��������" + count + "��");  
		        } else {  
		            // ���û���ҵ�����  
		            System.out.println("��Ǹ,��������Դ���Ҳ��������������");  
		        } 
	 }
	
}
