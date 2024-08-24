package p12759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.startPlayer, ip.draws));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int startPlayer = Integer.parseInt(br.readLine());

        int[][] draws = new int[9][2];
        for (int i = 0; i < draws.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            draws[i][0] = x;
            draws[i][1] = y;
        }

        return new Input(startPlayer, draws);
    }

    private static class Input {

        int startPlayer;
        int[][] draws;

        public Input(int startPlayer, int[][] draws) {
            this.startPlayer = startPlayer;
            this.draws = draws;
        }
    }
}

class Solution {

    public int solution(int startPlayer, int[][] draws) {
        Game g = new Game(startPlayer);
        for (int[] draw : draws) {
            g.check(draw);
            if(g.isDone()) return g.getWinner();
        }
        return 0;
    }
}

class Game {

    final int PLAYER_ONE = 1;
    final int PLAYER_TWO = 2;

    int prevPlayer;
    int[][] field;
    int winner = 0;

    public Game(int startPlayer) {
        this.prevPlayer = startPlayer == PLAYER_ONE ? PLAYER_TWO : PLAYER_ONE;
        this.field = new int[4][4];
    }

    public void check(int[] draw) {
        int x = draw[0];
        int y = draw[1];
        int player = getPlayer();
        field[x][y] = player;
        prevPlayer = player;
    }

    public boolean isDone() {
        return isLineDone() || isDiagonalDone();
    }

    public int getWinner() {
        return winner;
    }

    private boolean isLineDone() {
        for (int i = 1; i < field.length; i++) {
            int[] horizontalChecker = new int[3];
            int[] verticalChecker = new int[3];
            for (int j = 1; j < field.length; j++) {
                horizontalChecker[field[i][j]]++;
                verticalChecker[field[j][i]]++;
            }
            if(isWinnerExist(horizontalChecker)) return true;
            if(isWinnerExist(verticalChecker)) return true;
        }
        return false;
    }

    private boolean isDiagonalDone() {
        int[] checker = new int[3];
        int[] reversedChecker = new int[3];
        for (int i = 1; i < field.length; i++) {
            checker[field[i][i]]++;
            reversedChecker[field[i][4 - i]]++;
        }
        return isWinnerExist(checker) || isWinnerExist(reversedChecker);
    }

    private boolean isWinnerExist(int[] checker) {
        for (int i = 1; i < 3; i++) {
            if (checker[i] == 3) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    private int getPlayer() {
        return prevPlayer == PLAYER_ONE ? PLAYER_TWO : PLAYER_ONE;
    }
}