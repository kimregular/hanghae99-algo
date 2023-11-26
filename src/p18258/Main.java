package p18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfOrders = Integer.parseInt(br.readLine());
            MyQueue mq = new MyQueue();
            for (int i = 0; i < numOfOrders; i++) {
                String[] order = br.readLine().split(" ");
                mq.result(order);
            }
            System.out.println(mq.getSB());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyQueue {

    LinkedList<Integer> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public void result(String[] str) {
        switch (str[0]) {
            case "push":
                q.addLast(Integer.parseInt(str[1]));
                break;
            case "pop":
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.removeFirst()).append("\n");
                break;
            case "size":
                sb.append(q.size()).append("\n");
                break;
            case "empty":
                if(q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;
            case "front":
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.getFirst()).append("\n");
                break;
            case "back":
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.getLast()).append("\n");
                break;
        }

    }
    public String getSB() {
        return this.sb.toString();
    }
}