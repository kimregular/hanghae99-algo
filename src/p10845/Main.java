package p10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfOrders = Integer.parseInt(br.readLine());

            for (int i = 0; i < numOfOrders; i++) {
                String[] order = br.readLine().split(" ");
                queue.execute(order);
            }

            System.out.println(queue.answer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyQueue {

    Queue<Integer> q = new LinkedList<>();
    StringBuilder answer = new StringBuilder();
    int lastInput = 0;

    public void execute(String[] order) {
        switch (order[0]) {
            case "push":
                lastInput = Integer.parseInt(order[1]);
                q.offer(lastInput);
                break;
            case "pop":
                if (q.isEmpty()) answer.append(-1).append("\n");
                else answer.append(q.poll()).append("\n");
                break;
            case "size":
                answer.append(q.size()).append("\n");
                break;
            case "empty":
                if(q.isEmpty()) answer.append(1).append("\n");
                else answer.append(0).append("\n");
                break;
            case "front":
                if (q.isEmpty()) answer.append(-1).append("\n");
                else answer.append(q.peek()).append("\n");
                break;
            case "back":
                if (q.isEmpty()) answer.append(-1).append("\n");
                else answer.append(lastInput).append("\n");
        }

    }
}