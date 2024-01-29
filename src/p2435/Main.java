package p2435;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int days = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] tempers = new int[days];
            for (int i = 0; i < days; i++) {
                tempers[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution();
            System.out.println(s.solution(tempers, limit));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int[] tempers, int limit) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i <= tempers.length - limit; i++) {
            int temp = 0;
            for (int j = 0; j < limit; j++) {
                temp += tempers[i + j];
            }
            answer = Math.max(answer, temp);
        }

        return answer;
    }

    private int sumOfTempers(int[] tempers) {
        int result = 0;
        for (int x : tempers) {
            result += x;
        }
        return result;
    }
}