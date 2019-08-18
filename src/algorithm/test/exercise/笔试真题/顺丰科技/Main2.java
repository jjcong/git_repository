package algorithm.test.exercise.笔试真题.顺丰科技;

import java.util.*;

public class Main2 {
    public static int count = 0;

    public static int reverse(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (end + start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int x = start;
        int y = mid + 1;
        int z = 0;

        while (x <= mid && y <= end) {
            if (arr[x] <= arr[y]) {
                tmp[z++] = arr[x++];
            } else {
                tmp[z++] = arr[y++];
                count += mid - x + 1;
            }
        }

        while (x <= mid) tmp[z++] = arr[x++];
        while (y <= end) tmp[z++] = arr[y++];

        for (int s = 0; s < z; s++) {
            arr[s + start] = tmp[s];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] a = new int[l];
        int[] b = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < l; i++) {
            b[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(a[i], i);
        }
        int[] c = new int[l];
        for (int i = 0; i < l; i++) {
            c[i] = map.get(b[i]);
        }
        int s = reverse(c);
        System.out.println(s);
    }
}
