package algorithm.test.exercise.link;
/**
 * 两个链表倒叙相加 1->2->3     4->5->6         9->7->5
 * 
 * @author  j_cong
 * @date    2018/05/20
 * @version V1.0
 */
public class LinkAddTest {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int curSum = 0;

        while (l1 != null || l2 != null || curSum != 0) {
            if (l1 != null) {
                curSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curSum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(curSum % 10);
            cur = cur.next;
            curSum /= 10;
        }

        return dummy.next;
    }
}
