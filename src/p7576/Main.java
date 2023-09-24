package p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Solution s = new Solution(board);
            System.out.println(s.getDate());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[][] board;
    int[][] steps;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public Solution(int[][] board) {
        this.board = board;
        this.steps = new int[board.length][board[0].length];
    }

    private void BFS() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (isPossible(nx, ny)) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    steps[nx][ny] = steps[tmp.x][tmp.y] + 1;
                }

            }
        }


    }

    public int getDate() {
        BFS();

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0) return -1;
            }
        }

        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[i].length; j++) {
                answer = Math.max(answer, steps[i][j]);
            }
        }

        return answer;
    }

    private boolean isPossible(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == 0;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}