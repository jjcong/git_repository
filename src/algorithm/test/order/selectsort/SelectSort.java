package algorithm.test.order.selectsort;


/**
 * @author j_cong
 * @date 2017年9月14日
 * @describe 选择排序
 * @version V1.0.0
 */
public class SelectSort {

	private static void selectSort1(int[] a) {

	    //方式一
	    /*
        int i;
		int j;
		int min;
		for (i = 0; i < n; i++) {
			min = i;

			// 找出"a[i+1] ... a[n]"之间的最小元素，并赋值给min。
			for (j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			// 若min!=i，则交换 a[i] 和 a[min]。
			// 交换之后，保证了a[0] ... a[i] 之间的元素是有序的
			if (min != i) {
				int tmp = a[i];
				a[i] = a[min];
				a[min] = tmp;
			}
		}
		*/

	    //此方法就是插入排序思想
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int wait = a[i];

            //每次比较当前待排序的值与它之前的大小，如果小于就交换值
            while (j > 0 && wait < a[j - 1]) {
                //相当于将比wait大的数向右移一位
                a[j] = a[j - 1];
                j--;
            }
            //j为最终停止比较的序号
            a[j] = wait;

        }

	}

	public static void main(String[] args) {

		int a[] = { 10, 40, 30, 20, 60, 50 };

		System.out.printf("Before sort:");

		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}

		System.out.printf("\n");

		selectSort1(a);
		// shellSort2(a, a.length);

		System.out.printf("After sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}

}
