package p1268;

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
        int len = Integer.parseInt(br.readLine());
        int[][] board = new int[len][len];

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return board;
    }
}

class Solution {

    public int solution(int[][] board) {
        int answer = 0;
        int maxFriends = 0;
        for (int i = 0; i < board.length; i++) {
            int friends = 0;
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (board[i][k] == board[j][k]) {
                        friends++;
                        break;
                    }
                }
            }
            if (maxFriends < friends) {
                maxFriends = friends;
                answer = i+1;
            }
        }

        if(answer == 0) return 1;
        return answer;
    }
}