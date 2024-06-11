package p11727;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public int solution(int num) {
        if(num == 1) return 1;

        int[] board = new int[num + 1];
        board[1] = 1;
        board[2] = 3;
        for (int i = 3; i < board.length; i++) {
            board[i] = (board[i - 2] * 2 + board[i - 1]) % 10007;
        }
        return board[num];
    }
}