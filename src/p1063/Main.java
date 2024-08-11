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

    Position king;
    Position rock;

    private static final Map<String, int[]> moveConverter = Map.of("R", new int[]{0, 1}, "L", new int[]{0, -1}, "B", new int[]{1, 0}, "T", new int[]{-1, 0}, "RT", new int[]{-1, 1}, "LT", new int[]{-1, -1}, "RB", new int[]{1, 1}, "LB", new int[]{1, -1});

    public ChessBoard(String kingPosition, String rockPosition) {
        this.king = new Position(kingPosition);
        this.rock = new Position(rockPosition);
    }

    public void move(String order) {
        int[] move = moveConverter.get(order);

        Position newKingPosition = king.move(move);

        if(newKingPosition.isInvalidPosition()) return;

        if (rock.equals(newKingPosition)) {
            Position newRockPosition = rock.move(move);
            if(newRockPosition.isInvalidPosition()) return;
            rock = newRockPosition;
        }
        king = newKingPosition;
    }

    public String getResult() {
        return king.getPosition() + "\n" + rock.getPosition();
    }
}

class Position {

    int row;
    int col;
    private static final Map<String, Integer> positionConverter = Map.of("A", 0, "B", 1, "C", 2, "D", 3, "E", 4, "F", 5, "G", 6, "H", 7);
    private static final String[] reversePosition = {"A", "B", "C", "D", "E", "F", "G", "H"};

    private static int[] convert(String position) {
        String[] positionTemp = position.split("");
        return new int[]{8 - Integer.parseInt(positionTemp[1]), positionConverter.get(positionTemp[0])};
    }

    public Position(String position) {
        int[] convertedPosition = convert(position);
        this.row = convertedPosition[0];
        this.col = convertedPosition[1];
    }

    public Position(int x, int y) {
        this.row = x;
        this.col = y;
    }

    public String getPosition() {
        return reversePosition[col] + (8 - row);
    }

    public Position move(int[] move) {
        return new Position(row + move[0], col + move[1]);
    }

    public boolean isInvalidPosition() {
        return 0 > row || row >= 8 || 0 > col || col >= 8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}