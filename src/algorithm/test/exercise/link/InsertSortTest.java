package algorithm.test.exercise.link;
/**
 * 用插入排序实现对链表进行排序
 *
 * @author  j_cong
 * @date    2018/03/24
 * @version V1.0
 */
public class InsertSortTest {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(2);
        ListNode forth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        ListNode sixth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        ListNode head = first;
        insertionSortList(head);
    }


    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //已排序的最后一个节点，开始为head
        ListNode pre = head;
        //开始排序的第一个节点，从head.next开始排序
        ListNode cur = head.next;

        while (cur != null) {

            if (cur.val < pre.val) {
                ListNode next = cur.next;
                ListNode tmp = dummy;
                ListNode cur2 = dummy.next;

                while (cur.val > cur2.val && cur2 != pre) {
                    tmp = cur2;
                    cur2 = cur2.next;
                }
                //cur插入到tmp和cur2之间
                tmp.next = cur;
                cur.next = cur2;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;


    }
}
