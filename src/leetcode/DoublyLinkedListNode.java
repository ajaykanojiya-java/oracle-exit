package leetcode;

public class DoublyLinkedListNode {
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
