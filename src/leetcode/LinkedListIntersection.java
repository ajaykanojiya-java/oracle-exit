package leetcode;

import org.w3c.dom.NodeList;

public class LinkedListIntersection {

    public static void main(String[] args) {
        ListNode []lists = prepareTwoIntersectionList();

        ListNode headA = lists[0];
        ListNode headB = lists[1];

        System.out.println("Intersection Node: "+findIntersectionNode(headA,headB).val);

    }

    private static ListNode findIntersectionNode(ListNode headA, ListNode headB){

        //logic: combining list A + list B and list B + list A, then length of both list will be same
        //now the intersection node can be found at the same position from head of both linked list.
        //so we guaranteed to reach the intersection node at the same time.
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        //traverse through list A with ptrA and list B with ptrB until they meet
        while(ptrA != ptrB){
            //traverse from list A to list B using ptrA, upon reaching end of the list A,
            //continue traversal from the head of the list B
            ptrA = ptrA.next;
            if(ptrA == null)
                ptrA = headB;
            //simultaneously, traverse from list B to list A
            ptrB = ptrB.next;
            if(ptrB == null)
                ptrB = headA;
        }
        return ptrA;
    }

    private static ListNode[] prepareTwoIntersectionList(){
        ListNode list1_node1 = new ListNode(1);
        ListNode list1_node2 = new ListNode(2);
        ListNode list1_node3 = new ListNode(3);
        ListNode list1_node4 = new ListNode(4);
        ListNode list1_node5 = new ListNode(5);
        list1_node1.next = list1_node2;
        list1_node2.next = list1_node3;
        list1_node3.next = list1_node4;
        list1_node4.next = list1_node5;

        ListNode list2_node1 = new ListNode(11);
        ListNode list2_node2 = new ListNode(12);

        list2_node1.next = list2_node2;
        //made intersection node list1_node4
        list2_node2.next = list1_node4;

        return new ListNode[]{list1_node1,list2_node1};


    }
}
