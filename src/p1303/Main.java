package p1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[1]);
        int y = Integer.parseInt(tokens[0]);

        String[][] battleField = new String[x][y];
        for (int i = 0; i < battleField.length; i++) {
            battleField[i] = br.readLine().split("");
        }
        return battleField;
    }
}

class Solution {

    public String solution(String[][] battleField) {
        Calculator c = new Calculator(battleField);
        return c.getResult();
    }
}

class Calculator {

    private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private final String[][] battleField;
    private final boolean[][] isChecked;


    public Calculator(String[][] battleField) {
        this.battleField = battleField;
        this.isChecked = new boolean[battleField.length][battleField[0].length];
    }

    public String getResult() {
        explore();
        return String.format("%d %d", Team.WHITE.getPower(), Team.BLUE.getPower());
    }

    private void explore() {
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                if (isChecked[i][j]) continue;
                BFS(i, j);
            }
        }
    }

    private void BFS(int x, int y) {
        Team team = Team.getTeamOf(battleField[x][y]);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        isChecked[x][y] = true;
        int teamPower = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinBattleField(nx, ny) && !isChecked[nx][ny] && isTeam(team, nx, ny)) {
                    isChecked[nx][ny] = true;
                    teamPower++;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
        team.addPower(teamPower);
    }

    private boolean isWithinBattleField(int x, int y) {
        return 0 <= x && x < battleField.length && 0 <= y && y < battleField[x].length;
    }

    private boolean isTeam(Team team, int nx, int ny) {
        return team == Team.getTeamOf(battleField[nx][ny]);
    }

}

enum Team {
    WHITE("W"),
    BLUE("B");

    private final String symbol;
    private int power = 0;

    Team(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void addPower(int teamPower) {
        int newPower = teamPower * teamPower;
        this.power += newPower;
    }

    public int getPower() {
        return power;
    }

    public static Team getTeamOf(String symbol) {
        for (Team team : Team.values()) {
            if(team.getSymbol().equals(symbol)) return team;
        }
        return null;
    }
}