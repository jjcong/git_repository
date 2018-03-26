package algorithm.test.exercise.link;

import java.util.*;

/**
 * 删除链表中的重复值
 *
 * @author  j_cong
 * @date    2018/03/09
 * @version V1.0
 */
public class DeleteSameNodeTest {

    /**
     * 利用TreeSet的不能重复性和有序性，得到节点值得列表
     *
     * @param head
     * @return
     */
    public static ListNode deleteSameNode(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        //利用TreeSet的不能重复性和有序性，得到节点值得列表
        Set<Integer> set = new TreeSet<>();
        while (head1 != null) {
            set.add(head1.val);
            head1 = head1.next;
        }

        ListNode newHead = new ListNode(-1);

        //循环值列表，添加到链尾
        for (int tmp : set) {
            ListNode newNode = new ListNode(tmp);

            ListNode temp = newHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return newHead.next;
    }
    /**
     * 利用HashMap，优点是时间复杂度低，但是需要额外的存储空间来保存遍历过的值。时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static ListNode deleteSameNode1(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        ListNode temp = head;
        //辅助链表的头节点
        ListNode newHead = null;

        while (temp != null) {
            if (hashMap.containsKey(temp.val)) {
                newHead.next = temp.next;
            } else {
                hashMap.put(temp.val, 1);
                newHead = temp;
            }

            temp = temp.next;
        }
        return head;
    }

    /**
     * 双重循环遍历链表,优点：不需要额外的存储空间.时间复杂度O(n^2)
     *
     * @param head
     * @return
     */
    public static ListNode deleteSameNode2(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;

        while (temp != null) {
            ListNode p = temp;
            while (p.next != null) {
                if (temp.val == p.next.val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            temp = temp.next;
        }


        return head;
    }


    /**
     * 删除重复元素，不保留
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> map = new HashMap<>();
        ListNode tmp = head;
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode cur2 = newHead;

        while (tmp != null) {
            if (map.containsKey(tmp.val)) {
                map.put(tmp.val, 2);
            } else {
                map.put(tmp.val, 1);
            }

            tmp = tmp.next;
        }

        while (cur != null) {
            if (map.get(cur.val) == 1) {

                ListNode tmp1 = new ListNode(cur.val);

                cur2.next = tmp1;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        return newHead.next;
    }

    /**
     * 删除重复元素，不保留
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode pre = head;

        while (head != null) {
            ListNode p = head;
            int count = 0;
            while (p != null && p.val == head.val) {
                count++;
                p = p.next;
            }

            if (count == 1) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            } else {
                head = p;
            }
        }
        cur.next = null;
        return newHead.next;


    }

    public static void main(String[] args) {

        ListNode first = new ListNode(10);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(11);
        ListNode forth = new ListNode(12);
        ListNode fifth = new ListNode(12);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = null;

        ListNode head = first;

//        ListNode result = deleteSameNode1(head);
        ListNode result = deleteDuplicates(head);


        while (result != null) {
            System.out.print(result.val + "——>");
            result = result.next;
        }
        System.out.println();
    }


}
