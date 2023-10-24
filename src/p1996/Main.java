package p1996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            String[][] board = new String[n][n];

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split("");
                board[i] = Arrays.copyOf(tokens, n);
            }

            MineMapper mm = new MineMapper(board);
            StringBuilder sb = new StringBuilder();
            for (String[] strs : mm.makeMineMap()) {
                for (String str : strs) {
                    sb.append(str);
                }
                sb.append("\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MineMapper {

    String[][] board;
    String[][] mineMap;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public MineMapper(String[][] board) {
        this.board = board;
        this.mineMap = new String[board.length][board[0].length];
    }

    public String[][] makeMineMap() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].equals(".")) {
                    mineMap[i][j] = "*";
                } else {
                    int tmp = explore(i, j);

                    if (tmp >= 10) {
                        mineMap[i][j] = "M";
                    } else {
                        mineMap[i][j] = String.valueOf(tmp);
                    }
                }
            }
        }
        return mineMap;
    }

    private int explore(int i, int j) {
        int minesAroundIt = 0;
        for (int x = 0; x < 8; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];

            if (isWithinBoard(nx, ny)) {
                if (!board[nx][ny].equals(".")) {
                    minesAroundIt += Integer.parseInt(board[nx][ny]);
                }
            }
        }

        return minesAroundIt;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }


}