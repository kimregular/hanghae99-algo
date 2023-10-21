package p13903;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][m];

            for (int i = 0; i < board.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int numOfStepRules = Integer.parseInt(br.readLine());
            int[][] stepRules = new int[numOfStepRules][2];
            for (int i = 0; i < numOfStepRules; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                stepRules[i] = new int[]{x, y};
            }

            PathFinder pf = new PathFinder(board, stepRules);
            System.out.println(pf.getShortestStep());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    int[][] board;
    int[][] stepRules;

    public PathFinder(int[][] board, int[][] stepRules) {
        this.board = board;
        this.stepRules = stepRules;
    }

    public int getShortestStep() {
        int shortestStep = Integer.MAX_VALUE;

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1) {
                int step = findPath(new int[]{0, i});
                if (step != -1) {
                    shortestStep = Math.min(shortestStep, step);
                }
            }
        }
        return shortestStep == Integer.MAX_VALUE ? -1 : shortestStep;
    }

    private int findPath(int[] point) {
        int numOfSteps = 1;
        int[][] stepBoard = new int[board.length][board[0].length];
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(point);
        isVisited[point[0]][point[1]] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {

                int[] currentPoint = q.poll();

                for (int[] stepRule : stepRules) {
                    int nx = currentPoint[0] + stepRule[0];
                    int ny = currentPoint[1] + stepRule[1];

                    if (isWithinBoard(nx, ny) && board[nx][ny] == 1 && !isVisited[nx][ny]) {
                        stepBoard[nx][ny] = numOfSteps;
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            numOfSteps++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stepBoard[stepBoard.length - 1].length; i++) {
            if (isVisited[isVisited.length - 1][i]) {
                result = Math.min(result, stepBoard[stepBoard.length - 1][i]);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}
