package leetcode;
/*
* You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
*
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
* */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = prepareList1();
        ListNode list2 = prepareList2();
        ListNode mergedList = mergeTwoLists(list1,list2);
        printList(mergedList);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null)
            curr.next = list1;

         if(list2 != null)
             curr.next = list2;

        return result.next;
    }

    private static ListNode prepareList1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2; node2.next = node3;
        return node1;
    }

    private static ListNode prepareList2(){
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node4.next = node5; node5.next = node6;
        return node4;
    }

    private static void printList(ListNode mergedList) {
        while(mergedList!=null){
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
