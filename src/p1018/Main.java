package p1018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[][] board = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    if (tokens[j].equals("W")) {
                        board[i][j] = true;
                    } else {
                        board[i][j] = false;
                    }
                }
            }

            BoardPainter bp = new BoardPainter(board);
            System.out.println(bp.paintBoard());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class BoardPainter {

    boolean[][] board;

    public BoardPainter(boolean[][] board) {
        this.board = board;
    }

    public int paintBoard() {
        int numOfPaint = Integer.MAX_VALUE;

        for (int i = 0; i < board.length - 7; i++) {
            for (int j = 0; j < board[i].length - 7; j++) {
                numOfPaint = Math.min(numOfPaint, checkBoard(i, j));
            }
        }
        return numOfPaint;
    }

    private int checkBoard(int x, int y) {
        int paint = 0;
        int xRange = x + 8;
        int yRange = y + 8;

        boolean tile = board[x][y];

        for (int i = x; i < xRange; i++) {
            for (int j = y; j < yRange; j++) {

                if (board[i][j] != tile) {
                    paint++;
                }

                tile = !tile;
            }
            tile = !tile;
        }
        return Math.min(paint, 64 - paint);
    }
}