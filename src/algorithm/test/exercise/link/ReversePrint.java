package algorithm.test.exercise.link;

import java.util.Iterator;
import java.util.Stack;

/**
 * 反转打印链表
 *
 * @author  j_cong
 * @date    2018/03/29
 * @version V1.0
 */
public class ReversePrint {

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

        reversePrint1(head);
        reversePrint2(head);
        reversePrint3(head);

    }

    /**
     * 首先将链表反转后，在顺序输出
     *
     * @param head
     */
    private static void reversePrint1(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        ListNode newHead = null;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }

    /**
     * 利用stack的先进后出特点，实现倒叙输出
     *
     * @param head
     */
    private static void reversePrint2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        Iterator iter = stack.iterator();

        while (iter.hasNext()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 利用递归，实现倒叙输出，优点是不改变原有的链表结构
     *
     * @param head
     */
    private static void reversePrint3(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode cur = head;

        if (cur != null) {

            if (cur.next != null) {
                reversePrint3(cur.next);
            }

            System.out.print(cur.val + " ");
        }

    }
}
