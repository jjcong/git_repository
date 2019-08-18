package algorithm.test.exercise.笔试真题.小红书;


import algorithm.test.exercise.link.ListNode;

import java.util.Scanner;

public class InverseByK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode root = null;
        int group = 0;
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            root = toLink(arr);

            group = Integer.parseInt(sc.nextLine());
            root = reverseKGroup(root, group);

            while (root != null) {
                System.out.print(root.val + " ");
                root = root.next;
            }

        }


    }

    public static ListNode toLink(int[] s) {
        ListNode ln = new ListNode(s[0]);
        ListNode m = ln;
        for (int i = 1; i < s.length; i++) {
            ListNode tem = new ListNode(s[i]);
            m.next = tem;
            m = m.next;
        }
        return ln;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ans.next = head;
        ListNode p = ans;
        while (hasNext(p.next, k)) {
            p = reverse(p, k);
        }

        return ans.next;
    }

    private static boolean hasNext(ListNode p, int k) {
        while (k > 0 && p != null) {
            p = p.next;
            k--;
        }
        return k == 0;
    }

    private static ListNode reverse(ListNode front, int k) {
        ListNode from = front.next;
        ListNode head = from;
        ListNode cur = from.next;
        ListNode tmp = null;
        while (k > 1 && cur != null) {
            tmp = cur.next;
            cur.next = from;

            from = cur;
            cur = tmp;
            k--;
        }
        head.next = cur;
        front.next = from;
        return head;
    }


}
