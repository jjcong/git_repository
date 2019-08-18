package algorithm.test.exercise.剑指offer;

import algorithm.test.exercise.link.ListNode;

import java.util.Arrays;

/**
 * 找出两个链表中重复的第一个节点
 *
 * @author  j_cong
 * @date    2018/10/05
 * @version V1.0
 */
public class FindFirstCommonNode {


    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1 == pHead2) {
            return pHead1;
        }

        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode longLink = len1 > len2 ? pHead1 : pHead2;
        ListNode shortLink =  len1 > len2 ? pHead2 : pHead1;

        int diff = Math.abs(len1 - len2);

        for(int i = 0; i < diff; i++) {
            longLink = longLink.next;
        }

        while(longLink != null && shortLink != null) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }

        return longLink;

    }

    public int getLength(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1 == pHead2) {
            return pHead1;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        // 遍历完所在链表后从另外一个链表再开始
        // 当 p1 和 p2 都换到另一个链表时，它们对齐了：
        // （1）如果链表相交，p1 == p2 时为第一个相交点
        // （2）如果链表不相交，p1 和 p2 同时移动到末尾，p1 = p2 = null，然后退出循环

        while (p1 != p2) {
            p1 = (null == p1) ? pHead2 : p1.next;
            p2 = (null == p2) ? pHead1 : p2.next;
        }
        return p1;
    }
}
