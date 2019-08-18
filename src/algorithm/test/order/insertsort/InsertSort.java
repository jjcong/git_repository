package algorithm.test.order.insertsort;


/**
 * @author j_cong
 * @date 2017年9月14日
 * @describe 直接插入排序
 * @version V1.0.0
 */
public class InsertSort {

	/*
	 * 直接插入排序
	 * 
	 * 参数说明： 
	 *         a -- 待排序的数组
	 *         n -- 数组的长度
	 */
	public static void insertSort(int[] a, int n) {
		int i, j, k;
		
		for (i = 1; i < n; i++) {
			 //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
			for (j = i - 1; j >= 0; j--) {
				if (a[j] < a[i]) {
					break;
				}
			}
			//如找到了一个合适的位置
			if (j != i - 1) {
				//将比a[i]大的数据向后移
				int temp = a[i];

				for (k = i - 1; k > j; k--) {
					a[k + 1] = a[k];
					//将a[i]放到正确位置上
					a[k + 1] = temp;
				}
			}
		}	
	}
	public static void insertSort2 (int[] arr, int n) {


	    for (int i = 1; i < arr.length; i++) {

	        int wait = arr[i];
            int j = i - 1;

            while (j >= 0 && wait < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }


            //如果满足条件，则后移一位
//	        for (j = i - 1; j >= 0 && wait < arr[j]; j--) {
//	            arr[j + 1] = arr[j];
//            }
            //放置待排序的数
            arr[j + 1] = wait;
        }
    }

    public static void insertSort3 (int[] arr, int n) {


        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
            }
        }
    }

	public static void main(String[] args) {
		
		int[] a = {20, 40, 30, 10, 60, 50};
		
		System.out.println("Before sort:");
		for ( int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		insertSort3(a, a.length);
		
		System.out.println("After sort:");
		for ( int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
