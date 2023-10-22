package p1987;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] board = new char[n][m];

            for (int i = 0; i < n; i++){
                char[] tokens = br.readLine().toCharArray();
                board[i] = Arrays.copyOf(tokens, m);
            }

            PathFinder pf = new PathFinder(board);
            pf.getNumOfSteps(0, 0, 0);
            System.out.println(pf.maxNumOfSteps);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    char[][] board;
    boolean[] isVisited = new boolean[26];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int maxNumOfSteps = 0;

    public PathFinder(char[][] board) {
        this.board = board;
    }

    public void getNumOfSteps(int x, int y, int cnt) {
        if (isVisited[board[x][y] - 'A']) {
            maxNumOfSteps = Math.max(maxNumOfSteps, cnt);
            return;
        } else {
            isVisited[board[x][y] - 'A'] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isWithinBoard(nx, ny)) {
                    getNumOfSteps(nx, ny, cnt + 1);
                }
            }
            isVisited[board[x][y] - 'A'] = false;
        }
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}
