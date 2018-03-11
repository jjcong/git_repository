package algorithm.test.exercise.link;

/**
 * 链表反转测试
 *
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class ListReverseTest {

    /**
     * 链表反转，非递归实现
     *
     * @param head 初始链表头结点
     * @return     反转后的链表头结点
     */
    public static ListNode reverseList1 (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    /**
     * 链表反转，递归实现
     *
     * @param head
     * @return
     */
    // TODO: 2018-3-8 不理解！！！！ 
    public static ListNode reverseList2 (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 链表反转，双重循环实现，类似冒泡,每次反转相邻的两个节点
     *
     * @param head 初始链表头结点
     * @return     反转后的链表头结点
     */
    public static ListNode reverseList3 (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int tmp;
        int length = 0;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        for (int i = length - 1; i > 0; i--) {
            cur = head;
            next = head.next;

            for (int j = 0; j < i; j++) {
                tmp = cur.val;
                cur.val = next.val;
                next.val = tmp;

                cur = next;
                next = next.next;
            }
        }


        return head;
    }




    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = null;

        ListNode head = first;

//        head = reverseList1(head);
//        head = reverseList2(head);
        head = reverseList3(head);


    }
}
