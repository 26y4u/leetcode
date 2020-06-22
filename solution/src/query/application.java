package query;

import javafx.application.Application;

import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        circularQueue cq = new circularQueue(3);

        solution sq = new solution();
        System.out.print(sq.numSquares1(8));

    }
}
