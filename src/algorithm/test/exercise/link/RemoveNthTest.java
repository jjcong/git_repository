package algorithm.test.exercise.link;
/**
 * 删除链表倒数第n个节点
 *
 * @author  j_cong
 * @date    2018/04/09
 * @version V1.0
 */
public class RemoveNthTest {

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

        ListNode result = removeNthFromEnd(head, 2);


        while (result != null) {
            System.out.print(result.val + "——>");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = null;

        for (int i = 0; i < n - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next != null) {
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        } else if (slow == head) {
            head = null;
        }
        return head;
    }
}
