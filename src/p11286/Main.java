package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] input = getInput(br);

            Solution s = new Solution();
            System.out.println(s.solution(input));

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

    StringBuilder result = new StringBuilder();

    public String solution(int[] input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new AbsoluteComparator());

        for (int x : input) {
            if (x == 0) {
                if (!pq.isEmpty()) {
                    result.append(pq.poll());
                } else {
                    result.append(0);
                }
                result.append("\n");
            } else {
                pq.offer(x);
            }
        }
        return result.toString();
    }
}

class AbsoluteComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int A = Math.abs(o1);
        int B = Math.abs(o2);

        if(A == B) return Integer.compare(o1, o2);
        return Integer.compare(A, B);
    }
}
