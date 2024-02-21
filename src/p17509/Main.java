package p17509;

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

    private static int[][] getInput(BufferedReader br) throws IOException {
        int[][] input = new int[11][2];

        for (int i = 0; i < input.length; i++) {
            String[] q = br.readLine().split(" ");

            int requireTime = Integer.parseInt(q[0]);
            int penalty = Integer.parseInt(q[1]);

            input[i][0] = requireTime;
            input[i][1] = penalty;
        }

        return input;
    }
}

class Solution {

    public int solution(int[][] problems) {
        int answer = 0;
        int spentTime = 0;

        Arrays.sort(problems, Comparator.comparingInt(q -> q[0]));

        for (int[] q : problems) {
            spentTime += q[0];
            answer += spentTime + 20 * q[1];
        }

        return answer;
    }
}