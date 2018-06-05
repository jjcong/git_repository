package algorithm.test.exercise.link;
/**
 * 反转前k个结点
 *
 * @author  j_cong
 * @date    2018/05/19
 * @version V1.0
 */
public class ReverseInkGroup {

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
        reverseKGroup(first, 4);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next;
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++){
            for (int j = 1; j < k; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;

        }
        return dummy.next;
    }
}
