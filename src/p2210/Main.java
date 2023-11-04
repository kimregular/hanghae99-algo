package p2210;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[][] board = new String[5][5];


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 5; i++) {
                String[] tokens = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    board[i] = Arrays.copyOf(tokens, 5);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CombiFinder cf = new CombiFinder(board);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cf.findCombi(i, j);
            }
        }

        System.out.println(cf.combi.size());
    }
}

class CombiFinder {

    String[][] board;
    ArrayList<String> combi = new ArrayList<>();
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public CombiFinder(String[][] board) {
        this.board = board;
    }

    public void findCombi(int x, int y) {
        StringBuilder combination = new StringBuilder();
        exploreBoard(x, y,  combination);
    }

    public void exploreBoard(int x, int y, StringBuilder combination) {
        combination.append(board[x][y]);

        if (combination.length() >= 6) {
            if (!combi.contains(combination.toString())) {
                combi.add(combination.toString());
            }
            return;
        } else {
            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];

                if (isWithinBoard(nextX, nextY)) {
                    exploreBoard(nextX, nextY, combination);
                    combination.setLength(combination.length() - 1);
                }
            }
        }
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}