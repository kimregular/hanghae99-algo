package p15686;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.board, ip.target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = tokens[0];
        int target = tokens[1];

        int[][] board = new int[len][len];
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return new Input(target, board);
    }

    private static class Input {

        int target;
        int[][] board;

        public Input(int target, int[][] board) {
            this.target = target;
            this.board = board;
        }
    }
}

class Solution {

    public int solution(int[][] board, int target) {
        Calculator c = new Calculator(board, target);
        return c.getResult();
    }
}

class Calculator {

    int[][] board;
    int target;
    int[] selectedChickens;
    int result = Integer.MAX_VALUE;
    List<Point> houses = new ArrayList<>();
    List<Point> chickens = new ArrayList<>();

    public Calculator(int[][] board, int target) {
        this.board = board;
        this.target = target;
        this.selectedChickens = new int[target];
    }

    public int getResult() {
        init();
        select(0, 0);
        return result;
    }

    private void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) houses.add(new Point(i, j));
                else if (board[i][j] == 2) chickens.add(new Point(i, j));
            }
        }
    }

    public void select(int numOfSelected, int shopNum) {
        if (numOfSelected == target) {
            calc();
        } else {
            for (int i = shopNum; i < chickens.size(); i++) {
                selectedChickens[numOfSelected] = i;
                select(numOfSelected + 1, i + 1);
            }
        }
    }

    private void calc() {
        int sum = 0;
        for (Point house : houses) {
            int chickenDistance = Integer.MAX_VALUE;
            for (int i : selectedChickens) {
                Point selectedChicken = chickens.get(i);
                int distance = Math.abs(house.x - selectedChicken.x) + Math.abs(house.y - selectedChicken.y);
                chickenDistance = Math.min(chickenDistance, distance);
            }
            sum += chickenDistance;
        }
        result = Math.min(result, sum);
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}