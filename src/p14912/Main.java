package p14912;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int limit = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.solution(limit, target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int limit, int target) {
        int[] board = new int[limit + 1];

        for (int i = 1; i <= limit; i++) {
            fillBoard(board, i);
        }

        return board[target];
    }

    private void fillBoard(int[] board, int num) {
        while (num > 0) {
            board[num % 10]++;
            num /= 10;
        }
    }
}