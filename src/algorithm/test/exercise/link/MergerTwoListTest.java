package algorithm.test.exercise.link;
/**
 * 正序合并两个链表节点
 *
 * @author  j_cong
 * @date    2018/03/08
 * @version V1.0
 */
public class MergerTwoListTest {

    /**
     * 非递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //当前指针
        ListNode cur = new ListNode(-1);
        //输出新节点的头结点
        ListNode head = cur;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                //将l1的当前节点加入合并后的链表中
                cur.next = l1;
                //当前指针后移
                cur = l1;
                //链表1后移
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return head.next;
    }

    /**
     * 递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //输出新节点的头结点
        ListNode head;

        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists1(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists1(l1, l2.next);
        }

        return head;
    }
    /**
     * node1: 1->3->5->7;
     * node2: 2->4->6->8->9->10->11;
     * @param args
     */
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);

        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node8;
        node7.next = null;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = null;

        ListNode mergeNode = mergeTwoLists1(node1,node2);

        while(mergeNode != null) {
            System.out.print(mergeNode.val + "——>");  // 打印合并链表
            mergeNode = mergeNode.next;
        }

    }
}
