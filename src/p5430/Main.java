package p5430;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = getTestCase(br);
            for (int i = 0; i < TEST_CASE; i++) {
                Input ip = getInput(br);
                Solution s = new Solution();
                System.out.println(s.solution(ip.orders, ip.arr));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getTestCase(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }

    private static Input getInput(BufferedReader br) throws IOException{
        String orders = br.readLine();
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(orders, arr);
    }

    private static class Input{

        String orders;
        int[] arr;

        public Input(String orders, int[] arr) {
            this.orders = orders;
            this.arr = arr;
        }
    }
}

class Solution{

    public String solution(String orders, int[] arr){
        Deque<Integer> dq = getDeque(arr);
        boolean reverseFlag = false;
        boolean failFlag = false;

        for(String order : getOrders(orders)){
            if(failFlag) break;

            switch(order){
                case "R":
                    reverseFlag = !reverseFlag;
                    break;
                case "D":
                    if(dq.isEmpty()) {
                        failFlag = true;
                        break;
                    }
                    if(reverseFlag){
                        dq.pollLast();
                    }else{
                        dq.poll();
                    }
                    break;
            }
        }

        if(failFlag) return "error";
        return getResult(dq, reverseFlag);
    }

    private String getResult(Deque<Integer> dq, boolean reverseFlag) {
        if(dq.isEmpty()) return "[]";
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (!dq.isEmpty()) {
            if (reverseFlag) {
                result.append(dq.pollLast()).append(",");
            } else {
                result.append(dq.pollFirst()).append(",");
            }
        }
        result.setLength(result.length() - 1);
        result.append("]");
        return result.toString();
    }

    private String[] getOrders(String orders) {
        return orders.split("");
    }

    private Deque<Integer> getDeque(int[] arr){
        Deque<Integer> result = new LinkedList<>();
        for(int i : arr){
            result.offerLast(i);
        }
        return result;
    }
}