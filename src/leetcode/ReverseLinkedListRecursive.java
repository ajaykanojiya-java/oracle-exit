package leetcode;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;
        //node1.next = node1;

        ListNode newHead = reverseLinkedList(node1);
        while(newHead!=null){
            System.out.println(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null)
            return head;
        //recursively reverse the sublist starting from the next node
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        //now head has become the last node, so make head's next to null;
        head.next = null;
        return newHead;
    }
}
