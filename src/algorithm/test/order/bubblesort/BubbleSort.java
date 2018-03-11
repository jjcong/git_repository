package algorithm.test.order.bubblesort;

/**
 * 冒泡排序
 *
 * @author  j_cong
 * @date    2017/09/14
 * @version V1.0
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param a  待排序的数组
     * @param n  数组的长度
     */
	public static void bubbleSort1(int[] a, int n) {
		int i, j;
		
		for (i = n-1; i > 0; i--) {
			for (j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}


    /**
     * 冒泡排序
     *
     * @param a  待排序的数组
     * @param n  数组的长度
     */
	private static void bubbleSort2(int[] a, int n) {
		int i, j;
		int flag;      //标记
		
		for (i = n - 1; i > 0; i--) {
            //初始化标记为0
			flag = 0;
			for (j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;

                    //若发生交换，则标记为1
					flag = 1;
				}
			}
			
			if (flag == 0) {
				break;         //若没发生交换，说明数组已经有序
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
		
		bubbleSort2(a, a.length);
		
		System.out.println("After sort:");
		for ( int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
