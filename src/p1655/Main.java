package p1655;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    MidHeap mh = new MidHeap();

    public String solution(int[] nums) {

        StringBuilder result = new StringBuilder();
        for(int num : nums){
            mh.add(num);
            result.append(mh.getMidNum()).append("\n");
        }

        return result.toString();
    }
}

class MidHeap {

    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minQ = new PriorityQueue<>();

    public void add(int num) {
        if (maxQ.size() >= minQ.size()) {
            maxQ.add(num);
            minQ.add(maxQ.poll());
        } else {
            minQ.add(num);
            maxQ.add(minQ.poll());
        }
    }

    public int getMidNum() {
        if(maxQ.isEmpty() || maxQ.size() < minQ.size()) return minQ.peek();
        return maxQ.peek();
    }
}