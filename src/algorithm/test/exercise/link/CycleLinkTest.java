package algorithm.test.exercise.link;


/**
 * 检测链表中是否有环
 *
 * @author  j_cong
 * @date    2018/03/20
 * @version V1.0
 */
public class CycleLinkTest {

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
        sixth.next = third;

        ListNode head = first;
        hasCycle1(head);

        System.out.println(hasCycle1(head));
    }
    /**
     * 维护两个指针，一个步幅为1，另一个步幅为2，如果相遇说明有环
     *
     * @param head
     * @return
     */
    private boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static  boolean hasCycle1(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            ListNode aft = cur.next;
            if (aft == cur) {
                return true;
            }
            cur.next = head;
            cur = aft;
        }

        return false;
    }
}
