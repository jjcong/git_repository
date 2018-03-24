package algorithm.test.exercise.link;


import java.util.LinkedList;
import java.util.List;

/**
 * 反转链表中m->n的链
 * Given1->2->3->4->5->NULL, m = 2 and n = 4, return1->4->3->2->5->NULL.
 *
 * @author  j_cong
 * @date    2018/03/20
 * @version V1.0
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        ListNode head = first;
        reverseBetween(head, 2, 4);
        reverseStore(head);
    }


    /**
     * 分为三段，将中间段倒序后，前后相接即可
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++){

            if (head.next != null){
                head = head.next;
            }
        }
        ListNode pre = head;
        //后面的循环打乱了顺序，因此fNode最后为单点2
        ListNode fNode = head.next;
        ListNode newHead = null;
        ListNode cur = fNode;

        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }
        pre.next = newHead;
        //cur 为5,6
        fNode.next = cur;

        return dummy.next;
    }

    /**
     * Given 1 -> 2 -> 3 -> null, return [3,2,1].
     *
     * @param head
     * @return
     */
    public static List<Integer> reverseStore(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode newHead = null;

        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        List<Integer> result = new LinkedList<>();
        while (newHead != null) {
            result.add(newHead.val);
            newHead = newHead.next;
        }

        return result;
    }
}
