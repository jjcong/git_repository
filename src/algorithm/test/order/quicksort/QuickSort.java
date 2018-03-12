package algorithm.test.order.quicksort;

/**
 * @author j_cong
 * @date 2017年9月14日
 * @describe 快速排序
 * @version V1.0.0
 */
public class QuickSort {
	/*
	 * 快速排序
	 * 
	 * 参数说明： a -- 待排序的数组 
	 *           l -- 数组的左边界(例如，从起始位置开始排序，则l=0) 
	 *           r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
	 */
	public static void quickSort(int[] a, int l, int r) {
		if (l < r) {
			int i, j, x;
			
			i = l;
			j = r;
			x = a[i];
			while (i < j) {
				while (i < j && a[j] > x) {
					j--;       //从右向左找第一个小于x的数
				}
				if (i < j) {
					a[i++] = a[j];
				}
				while (i < j && a[i] < x) {
					i++;       //从左向右找第一个大于x的数
				}
				if (i < j) {
					a[j--] = a[i];
				}
			}
			a[i] = x;
			quickSort(a, l, i-1);   //递归调用
			quickSort(a, i+1, r);   //递归调用
			
		}
	}
	public static void quickSort2(int[] arr, int low, int high) {

	    if (low >= high) {
	        return;
        }

        int pivot = partition(arr, low, high);

	    //递归排序左子数组
	    quickSort2(arr, low, pivot - 1);
        //递归排序右子数组
	    quickSort2(arr, pivot + 1, high);

    }

    public static int partition(int[] arr, int low, int high) {
	    //中心设置
	    int pivot = arr[low];

	    while (low < high) {
	        while (low < high && arr[high] >= pivot) {
	            high--;
            }
            //交换比中心小的记录到左端
            arr[low] = arr[high];

	        while (low < high && arr[low] <= pivot) {
	            low++;
            }
            //交换比中心小的记录到左端
            arr[high] = arr[low];

        }
        //扫描完成，中心到位
        arr[low] = pivot;

	    return low;
    }
	public static void main(String[] args) {
		int a[] = {30, 40, 60, 10, 20, 50};
		
		System.out.println("Before sort:");
		for ( int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		quickSort2(a, 0, a.length-1);
		
		System.out.println("After sort:");
		for ( int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();	
	}
	
	
	
}
