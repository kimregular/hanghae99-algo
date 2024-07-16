package p1417;

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

    public int solution(int[] people) {
        int threshold = people[0];
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < people.length; i++) {
            pq.add(people[i]);
        }

        if (pq.isEmpty()) {
            return answer;
        }

        while (pq.peek() >= threshold) {
            int cur = pq.poll();
            cur--;
            threshold++;
            answer++;
            pq.add(cur);
        }

        return answer;
    }
}