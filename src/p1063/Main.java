package p1063;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.kingPosition, ip.rockPosition, ip.orders));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        String kingPosition = tokens[0];
        String rockPosition = tokens[1];
        int len = Integer.parseInt(tokens[2]);

        String[] orders = new String[len];
        for (int i = 0; i < orders.length; i++) {
            orders[i] = br.readLine();
        }
        return new Input(kingPosition, rockPosition, orders);
    }

    private static class Input {

        String kingPosition;
        String rockPosition;
        String[] orders;

        public Input(String kingPosition, String rockPosition, String[] orders) {
            this.kingPosition = kingPosition;
            this.rockPosition = rockPosition;
            this.orders = orders;
        }
    }
}

class Solution {

    public String solution(String kingPosition, String rockPosition, String[] orders) {
        ChessBoard game = new ChessBoard(kingPosition, rockPosition);
        for (String order : orders) {
            game.move(order);
        }
        return game.getResult();
    }
}

class ChessBoard {

    int[][] board = new int[8][8];
    int[] kingPosition;
    int[] rockPosition;

    private static final Map<String, Integer> positionConverter = Map.of("A", 0, "B", 1, "C", 2, "D", 3, "E", 4, "F", 5, "G", 6, "H", 7);
    private static final Map<String, int[]> moveConverter = Map.of("R", new int[]{0, 1}, "L", new int[]{0, -1}, "B", new int[]{1, 0}, "T", new int[]{-1, 0}, "RT", new int[]{-1, 1}, "LT", new int[]{-1, -1}, "RB", new int[]{1, 1}, "LB", new int[]{1, -1});

    private static int[] convertPosition(String position) {
        String[] positionTemp = position.split("");
        return new int[]{8 - Integer.parseInt(positionTemp[1]), positionConverter.get(positionTemp[0])};
    }

    public ChessBoard(String kingPosition, String rockPosition) {
        this.kingPosition = convertPosition(kingPosition);
        this.rockPosition = convertPosition(rockPosition);
    }

    public void move(String order) {
        int[] move = moveConverter.get(order);
        int[] originalKingPosition = kingPosition;
        int nx = kingPosition[0] + move[0];
        int ny = kingPosition[1] + move[1];

        if (isOutBoard(nx, ny)) {
            return;
        }
        kingPosition = new int[]{nx, ny};

        if (Arrays.equals(kingPosition, rockPosition)) {
            nx = rockPosition[0] + move[0];
            ny = rockPosition[1] + move[1];
            if (isOutBoard(nx, ny)) {
                kingPosition = originalKingPosition;
                return;
            }
            rockPosition = new int[]{nx, ny};
        }

    }

    public String getResult() {
        return getPosition(kingPosition) + "\n" + getPosition(rockPosition);
    }

    private String getPosition(int[] position) {
        String stringPosition = "";
        for (String key : positionConverter.keySet()) {
            if (positionConverter.get(key) == position[1]) {
                stringPosition = key;
                break;
            }
        }
        return stringPosition + (8 - position[0]);
    }

    private boolean isOutBoard(int x, int y) {
        return 0 > x || x >= board.length || 0 > y || y >= board[x].length;
    }

}