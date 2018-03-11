package algorithm.test.order.selectsort;


/**
 * @author j_cong
 * @date 2017年9月14日
 * @describe 选择排序
 * @version V1.0.0
 */
public class SelectSort {

	private static void selectSort(int[] a) {

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

	    //方式二
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int wait = a[i];

            while (j > 0 && wait < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = wait;

        }

	}

	public static void main(String[] args) {

		int a[] = { 20, 40, 30, 10, 60, 50 };

		System.out.printf("Before sort:");

		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}

		System.out.printf("\n");

		selectSort(a);
		// shellSort2(a, a.length);

		System.out.printf("After sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}

}
