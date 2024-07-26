package p1715;

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

    public int solution(int[] nums) {
        int answer = 0;
        PriorityQueue<Integer> pq = getPQ(nums);

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            int next = num1 + num2;
            answer += next;
            pq.add(next);
        }

        return answer;
    }

    private PriorityQueue<Integer> getPQ(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        return pq;
    }
}