package p11268;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] input = getInput(br);

            Solution s = new Solution();
            s.solution(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;
    }
}

class Solution {

    public void solution(int[] input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int A = Math.abs(o1);
            int B = Math.abs(o2);

            if (A > B) {
                return A - B;
            } else if (A == B) {
                return o1 - o2;
            } else {
                return -1;
            }
        });

        for (int x : input) {
            if (x == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                pq.offer(x);
            }
        }
    }
}
