package algorithm.test.exercise.link;

/**
 * 返回链表倒数第n节点
 *
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class ReturnNodeTest {

    /**
     * 单链表只有头指针，所以只能从头部开始寻找，先遍历一遍链表，确定链表中节点的个数length。
     * 然后从前往后第确定链表中节点的个数length-n+1个节点就是倒数第n个节点。一共遍历2次链表
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode nthToLast1(ListNode head, int n) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode result = head;
        int length = 0;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        for(int i = 0; i < (length - n); i++) {

            result = result.next;
        }

        return result;
    }

    /**
     * 只遍历一次链表。设置2个指针，当第一个指针从表头向前走到第n-1个节点时，
     * 第二个指针开始从表头出发。当第一个指针走到尾节点时，第二个指针的位置即为倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode nthToLast2(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0) {
            return null;
        }

        ListNode former, latter;
        former = head;

        //第一个指针开始遍历，保证输出的n值小于链表的长度，否则返回null
        for (int i = 0; i < n - 1; i++) {
            if (former.next != null) {
                former = former.next;
            } else {
                return null;
            }
        }

        latter = head;

        while (former.next != null) {
            former = former.next;
            latter = latter.next;
        }


        return latter;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        int length = 0;
        ListNode p = head;

        while (p != null) {
            length++;
            p = p.next;
        }

        ListNode result = head;
        ListNode tmp = head;
        for (int i = 0; i < length - n - 1; i++) {
            result.next = tmp.next;
            tmp = tmp.next;
        }
        result.next = tmp.next.next;

        return result;
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

//        ListNode result = nthToLast2(head, 2);
        ListNode result = removeNthFromEnd(head, 2);


        while (result != null) {
            System.out.print(result.val + "——>");
            result = result.next;
        }
        System.out.println();
    }
}
