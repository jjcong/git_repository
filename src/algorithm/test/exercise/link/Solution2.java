package algorithm.test.exercise.link;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution2 {

    public static void main(String[] args) {

        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node.random = node3;
        node2.random = node5;
        //NOde3.random = node5;
        node4.random = node2;
        //NOde5.random = node;

        Clone(node);

    }


    public static RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode ppHead = pHead;
        RandomListNode temp = head;
        while (ppHead.next != null) {
            RandomListNode node = new RandomListNode(ppHead.next.label);
            temp.next = node;
            temp = node;
            ppHead = ppHead.next;
        }

        temp = head;
        ppHead = pHead;
        while (temp != null && ppHead != null) {

            if (ppHead.random != null) {
                temp.random = ppHead.random;

            }
            temp = temp.next;
            ppHead = ppHead.next;
        }

        return head;
    }
}
