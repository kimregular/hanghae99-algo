package p11660;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int TEST_CASE = Integer.parseInt(st.nextToken());

            int[][] board = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < n + 1; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken()) + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
                }
            }

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                st = new StringTokenizer(br.readLine(), " ");

                int startX = Integer.parseInt(st.nextToken());
                int startY = Integer.parseInt(st.nextToken());
                int endX = Integer.parseInt(st.nextToken());
                int endY = Integer.parseInt(st.nextToken());

                int answer = board[endX][endY] - board[endX][startY - 1] - board[startX - 1][endY] + board[startX - 1][startY - 1];
                System.out.println(answer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
