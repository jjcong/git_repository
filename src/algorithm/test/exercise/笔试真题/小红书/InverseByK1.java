package algorithm.test.exercise.笔试真题.小红书;

/**
 * 将链表按照K个分组反转输出
 * 
 * @author  j_cong
 * @date    2018/09/15
 * @version V1.0
 */
import algorithm.test.exercise.link.ListNode;

import java.util.List;
import java.util.Scanner;

public class InverseByK1 {

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
            m = (ListNode) m.next;
        }
        return ln;
    }


    public static ListNode reverseLinkNode(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode cur = root;
        ListNode newHead = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        ListNode re = head;
        ListNode pre = null;
        int len = 0;
        while (len++ != k) {
            if (fast == null) {
                return head;
            }
            pre = fast;
            fast = fast.next;
        }
        pre.next = null;
        re = reverseLinkNode(head);
        head.next = reverseKGroup(fast, k);
        return re;
    }

}
