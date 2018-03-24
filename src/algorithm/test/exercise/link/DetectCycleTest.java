package algorithm.test.exercise.link;
/**
 * 返回链表中的环起始点
 * 
 * @author  j_cong
 * @date    2018/03/20
 * @version V1.0
 */
public class DetectCycleTest {
    /**
     * 当slow与fast第一次相遇时，令slow= head，slow与fast循环下一步，
     * 当两者相等时，slow即为环的起始点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
    
    
}
