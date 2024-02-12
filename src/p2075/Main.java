package p2075;

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
        int num = Integer.parseInt(br.readLine());

        int[][] board = new int[num][num];

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return board;
    }
}

class Solution {

    public int solution(int[][] board) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < board[i].length; j++) {
                pq.offer(board[i][j]);
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                pq.offer(board[i][j]);
                pq.poll();
            }
        }
        return pq.poll();
    }
}