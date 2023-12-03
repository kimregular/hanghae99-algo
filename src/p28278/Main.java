package p28278;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfOrders = Integer.parseInt(br.readLine());
            MyStack ms = new MyStack();
            for (int i = 0; i < numOfOrders; i++) {
                String[] tokens = br.readLine().split(" ");
                ms.doOrder(tokens);
            }
            System.out.println(ms.getAnswer());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyStack {

    Stack<Integer> stck = new Stack<>();
    StringBuilder answer = new StringBuilder();


    public void doOrder(String[] order) {
        switch (order[0]) {
            case "1" :
                this.stck.push(Integer.parseInt(order[1]));
                break;
            case "2":
                if(this.stck.isEmpty()) answer.append(-1).append("\n");
                else answer.append(this.stck.pop()).append("\n");
                break;
            case "3":
                answer.append(this.stck.size()).append("\n");
                break;
            case "4":
                if(this.stck.isEmpty()) answer.append(1).append("\n");
                else answer.append(0).append("\n");
                break;
            case "5":
                if(this.stck.isEmpty()) answer.append(-1).append("\n");
                else answer.append(this.stck.peek()).append("\n");
                break;
        }
    }

    public String getAnswer() {
        return this.answer.toString();
    }
}