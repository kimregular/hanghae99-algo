package p28279;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        String[] orders = new String[len];

        for (int i = 0; i < orders.length; i++) {
            orders[i] = br.readLine();
        }
        return orders;
    }
}

class Solution {

    public String solution(String[] orders) {
        DequeueOperator dqo = new DequeueOperator(orders);
        return dqo.getResult();
    }

    class DequeueOperator {

        String[] orders;

        LinkedList<Integer> dq = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        public DequeueOperator(String[] orders) {
            this.orders = orders;
        }

        public String getResult() {
            for (String order : this.orders) {
                String[] tempOrder = order.split(" ");
                calc(tempOrder);
            }
            return this.result.toString();
        }

        private void calc(String[] order) {
            boolean newLineFlag = true;

            int orderNum = Integer.parseInt(order[0]);

            if (orderNum == 1) {
                newLineFlag = false;
                this.dq.addFirst(Integer.parseInt(order[1]));
            } else if (orderNum == 2) {
                newLineFlag = false;
                this.dq.addLast(Integer.parseInt(order[1]));
            } else if (orderNum == 3) {
                if (this.dq.isEmpty()) {
                    this.result.append( "-1");
                } else {
                    String value = String.valueOf(this.dq.getFirst());
                    this.dq.removeFirst();
                    this.result.append(value);
                }
            } else if (orderNum == 4) {
                if (this.dq.isEmpty()) {
                    this.result.append("-1");
                } else {
                    String value = String.valueOf(this.dq.getLast());
                    this.dq.removeLast();
                    this.result.append(value);
                }
            } else if (orderNum == 5) {
                this.result.append(this.dq.size());
            } else if (orderNum == 6) {
                if (this.dq.isEmpty()) {
                    this.result.append("1");
                } else {
                    this.result.append("0");
                }
            } else if (orderNum == 7) {
                if (this.dq.isEmpty()) {
                    this.result.append("-1");
                } else {
                    this.result.append(this.dq.getFirst());
                }
            } else if (orderNum == 8) {
                if (this.dq.isEmpty()) {
                    this.result.append("-1");
                } else {
                    this.result.append(this.dq.getLast());
                }
            }
            if(newLineFlag)this.result.append("\n");
        }
    }
}