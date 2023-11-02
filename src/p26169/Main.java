package p26169;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] board = new int[5][5];

            for (int i = 0; i < 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 5; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            AppleFinder af = new AppleFinder(board);
            System.out.println(af.findApple(x, y, 0, 0));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class AppleFinder {

    int[][] board;
    boolean[][] isVisited = new boolean[5][5];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public AppleFinder(int[][] board) {
        this.board = board;
    }

    public int findApple(int x, int y, int numOfApple, int num) {
        isVisited[x][y] = true;
        if (board[x][y] == 1) {
            numOfApple += 1;
        }
        if (num == 3) {
            if (numOfApple >= 2){
                return 1;
            }
        }else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isWithinBoard(nx, ny) && board[nx][ny] != -1 && !isVisited[nx][ny]) {
                    if (findApple(nx, ny, numOfApple, num + 1) == 1) {
                        return 1;
                    }
                }
            }
        }
        isVisited[x][y] = false;
        return 0;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}