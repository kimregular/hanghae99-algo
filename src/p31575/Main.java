package p31575;

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
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[1]);
        int y = Integer.parseInt(tokens[0]);

        int[][] board = new int[x][y];

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

    public String solution(int[][] board) {
        PathFinder pf = new PathFinder(board);
        if(pf.getResult()) return "Yes";
        return "No";
    }

    private class PathFinder{

        int[][] board;
        boolean[][] isVisited;
        int[][] directions = {{1, 0}, {0, 1}};

        public PathFinder(int[][] board) {
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
        }

        public boolean getResult() {
            findPath(0, 0);
            return this.isVisited[isVisited.length - 1][isVisited[0].length - 1];
        }

        private void findPath(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x, y});
            this.isVisited[x][y] = true;

            while (!q.isEmpty()) {
                int[] curPoint = q.poll();
                int cx = curPoint[0];
                int cy = curPoint[1];

                for (int[] direction : directions) {
                    int nx = cx + direction[0];
                    int ny = cy + direction[1];

                    if (isWithinBoard(nx, ny) && !this.isVisited[nx][ny] && this.board[nx][ny] == 1) {
                        this.isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < this.board.length && 0 <= y && y < this.board[x].length;
        }
    }
}
