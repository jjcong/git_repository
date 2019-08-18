package algorithm.test.exercise.link;
/**
 * 链表排序
 *
 * @author  j_cong
 * @date    2018/10/06
 * @version V1.0
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;

        return mergeList(sortList(head), sortList(next));

    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode p, ListNode q) {
        if(p == null) {
            return q;
        }
        if(q == null) {
            return p;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;


        while(p != null && q != null) {
            if(p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p != null ? p : q;
        return dummy.next;
    }
}
