package query;

import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        circularQueue cq = new circularQueue(3);
        System.out.println(cq.enQueue(1));
        System.out.println(cq.enQueue(2));
        System.out.println(cq.enQueue(3));
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
        System.out.println(cq.isFull());

        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());


    }
}
