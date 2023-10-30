package p10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyDeque md = new MyDeque();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfOrders = Integer.parseInt(br.readLine());

            for (int i = 0; i < numOfOrders; i++) {
                String[] orders = br.readLine().split(" ");
                md.execute(orders);
            }
            System.out.println(md.answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyDeque {

    Deque<Integer> myDeque = new LinkedList<>();
    StringBuilder answer = new StringBuilder();

    public void execute(String[] order) {
        switch (order[0]) {
            case "push_back":
                myDeque.offerLast(Integer.parseInt(order[1]));
                break;
            case "push_front":
                myDeque.offerFirst(Integer.parseInt(order[1]));
                break;
            case "pop_front":
                if(myDeque.isEmpty()) answer.append(-1).append("\n");
                else answer.append(myDeque.pollFirst()).append("\n");
                break;
            case "pop_back":
                if(myDeque.isEmpty()) answer.append(-1).append("\n");
                else answer.append(myDeque.pollLast()).append("\n");
                break;
            case "empty":
                if(myDeque.isEmpty()) answer.append(1).append("\n");
                else answer.append(0).append("\n");
                break;
            case "front":
                if(myDeque.isEmpty()) answer.append(-1).append("\n");
                else answer.append(myDeque.peekFirst()).append("\n");
                break;
            case "back":
                if(myDeque.isEmpty()) answer.append(-1).append("\n");
                else answer.append(myDeque.peekLast()).append("\n");
                break;
            case "size":
                answer.append(myDeque.size()).append("\n");
                break;
        }
    }
}
