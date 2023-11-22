package p2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Board board = new Board(x, y);

            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < y; j++) {
                    board.fillBoard(i, j, Integer.parseInt(st.nextToken()));
                }
            }

            int RESULT_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < RESULT_CASE; CASE++) {
                int result = 0;
                st = new StringTokenizer(br.readLine(), " ");
                int startX = Integer.parseInt(st.nextToken()) - 1;
                int startY = Integer.parseInt(st.nextToken()) - 1;
                int limitX = Integer.parseInt(st.nextToken());
                int limitY = Integer.parseInt(st.nextToken());

                for (int i = startX; i < limitX; i++) {
                    for (int j = startY; j < limitY; j++) {
                        result += board.getValue(i, j);
                    }
                }
                System.out.println(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Board {

    int x;
    int y;
    int[][] board;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.board = new int[this.x][this.y];
    }

    public void fillBoard(int x, int y, int value) {
        this.board[x][y] = value;
    }

    public int getValue(int x, int y) {
        return this.board[x][y];
    }
}