package list;


import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world");

        ListNode a = new  ListNode(2);
        ListNode b = new  ListNode(4);
        ListNode c = new  ListNode(3);
        ListNode d = new  ListNode(5);
        ListNode e = new  ListNode(6);
        ListNode f = new  ListNode(4);

        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        solution s = new solution();
        s.addTwoNumbers(a,d);
    }
}
