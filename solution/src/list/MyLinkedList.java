package list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next=null;}
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
class MyLinkedList {
    private int size;
    private ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        head.next = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index>=size || index<0){
            return -1;
        }
        ListNode temp = head;
        for (int i = 0;i<index;i++){
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        }
        if (index<=0){
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
            size++;
        }
        else {
            ListNode temp = head;
            ListNode node = new ListNode(val);
            for (int i = 0;i<index-1;i++){
                temp = temp.next;
            }
            ListNode temp1 = temp.next;
            temp.next = node;
            node.next = temp1;
            size++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<=0 || index>size){
            return;
        }
        else if (index == 1){
            ListNode temp = head;
            head.val = temp.next.val;
            head.next = temp.next.next;
            size--;
        }
        else if(index == size){
            ListNode temp = head;
            for (int i = 1;i<index-1;i++){
                temp = temp.next;
            }
            temp.next = null;
        }
        else {
            ListNode temp = head;
            for (int i = 1;i<index;i++){
                temp = temp.next;
            }
            ListNode temp1 = temp.next;
            temp.next = temp1.next;
            size--;
        }

    }
}