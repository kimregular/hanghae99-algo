package p12050;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int testCase = 0; testCase < TEST_CASE; testCase++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[][] board = new int[n][m];

                for (int i = 0; i < n; i++) {
                    char[] tokens = br.readLine().toCharArray();
                    for (int j = 0; j < m; j++) {
                        board[i][j] = Integer.parseInt(String.valueOf(tokens[j]));
                    }
                }

                PathFinder pf = new PathFinder(board);
                int repeatNum = Integer.parseInt(br.readLine());

                System.out.println("Case #" + (testCase+1) + ":");
                for (int i = 0; i < repeatNum; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    pf.operate(st);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    int[][] board;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public PathFinder(int[][] board) {
        this.board = board;
    }

    public void operate(StringTokenizer st) {
        String operation = st.nextToken();
        switch (operation) {
            case "M":
                operationM(st);
                break;
            case "Q":
                operationQ();
                break;
        }
    }

    private void operationM(StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        board[x][y] = value;
    }

    private void operationQ() {
        int numOfConnected = 0;
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && !isVisited[i][j]) {
                    numOfConnected++;
                    explore(i, j, isVisited);
                }
            }
        }
        System.out.println(numOfConnected);
    }

    private void explore(int x, int y, boolean[][] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        isVisited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] currentPosition = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = currentPosition[0] + dx[j];
                    int ny = currentPosition[1] + dy[j];

                    if (isWithinBoard(nx, ny) && board[nx][ny] == 1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}