public class CycleInLinkedList {

        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;
            //node1.next = node1;

            System.out.println("Has Cycle: "+hasCycle(node1));
            reverseLinkedList(node1);
        }
        private static boolean hasCycle(ListNode head){

            if(head ==null || head.next == null)
                return false; //cycle is not possible
            if (head == head.next)
                return true;

            ListNode slow = head;
            ListNode fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow)
                    return true;
            }
            return false;
        }

        private static void reverseLinkedList(ListNode head){
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            while(curr != null){
                next = curr.next; //store next node
                curr.next = prev; //reverse the current node pointer
                prev = curr; // move prev to curr
                curr = next; //move curr to next
            }
            while(prev != null) {
                System.out.println("Element " + prev.value);
                prev = prev.next;
            }
        }
}
