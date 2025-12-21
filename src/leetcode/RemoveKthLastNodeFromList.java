package leetcode;

/*
* Input: head = [1,2,3,4,5], n = 2
* Output: [1,2,3,5]
* */
public class RemoveKthLastNodeFromList {

    public static void main(String[] args) {
        ListNode head = prepareList();
        int k = 1;
        printList(head);
        ListNode newHead = removeKthLastNode(head,k);
        printList(newHead);
    }

    private static ListNode removeKthLastNode(ListNode head, int k){
        //A dummy node to ensure there is a node before head in case we need to remove the head node.
        ListNode dummy = new ListNode();
        ListNode leader = dummy;
        ListNode trailer = dummy;
        dummy.next = head;
        //advance leader k step ahead
        for(int i=0;i<k;i++){
            leader = leader.next;
            //if k is larger than the list, no node to remove
            if(leader == null)
                return head;
        }
        //move leader to the end of the list, keeping trailer k nodes behind
        while(leader.next!=null){
            leader = leader.next;
            trailer = trailer.next;
        }
        //remove the kth node from the end.
        trailer.next = trailer.next.next;
        return dummy.next;
    }

    private static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode prepareList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}
