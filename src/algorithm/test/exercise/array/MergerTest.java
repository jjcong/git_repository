package algorithm.test.exercise.array;

public class MergerTest {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        MergerTest test = new MergerTest();
        String str = "A man, a plan, a canal: Panama";
        test.isPalindrome(str);

        merge(nums1,3, nums2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int[] tmp = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            tmp[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            tmp[k++] = nums1[i++];
        }
        while (j < n) {
            tmp[k++] = nums2[j++];
        }

        for (int s = 0; s < k; s++) {
            nums1[s] = tmp[s];
        }
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int index = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[index--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }

    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if (!isAlphaOrNumber(c1))  {
                start++;
                continue;
            }
            if (!isAlphaOrNumber(c2))  {
                end--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isAlphaOrNumber(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
