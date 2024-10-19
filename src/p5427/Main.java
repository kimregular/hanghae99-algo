package p5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<char[][]> readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        List<char[][]> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            String[] tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[0]);
            char[][] field = new char[x][y];
            for (int j = 0; j < x; j++) {
                field[j] = br.readLine().toCharArray();
            }
            result.add(field);
        }
        return result;
    }
}

class Solution {

    public String solution(List<char[][]> testCases) {
        StringBuilder answer = new StringBuilder();
        for (char[][] testCase : testCases) {
            EscapeSimulator es = new EscapeSimulator(testCase);
            answer.append(es.getResult()).append("\n");
        }
        return answer.toString();
    }
}

class EscapeSimulator {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private final char[][] building;
    private final boolean[][] isVisited;
    private final int[][] fireBoard;

    private final Queue<int[]> humanLocation = new ArrayDeque<>();
    private final Queue<int[]> fireLocation = new ArrayDeque<>();

    private int result = Integer.MAX_VALUE;

    public EscapeSimulator(char[][] building) {
        this.building = building;
        this.isVisited = new boolean[building.length][building[0].length];
        this.fireBoard = new int[building.length][building[0].length];
        for (int[] ints : fireBoard) {
            Arrays.fill(ints, -1);
        }
    }

    public String getResult() {
        simulateEscape(init());
        if(result == Integer.MAX_VALUE) return "IMPOSSIBLE";
        return result + "";
    }

    private int[] init() {
        int x = building.length;
        int y = building[0].length;

        int[] startPosition = new int[3];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (building[i][j] == '@') {
                    isVisited[i][j] = true;
                    startPosition = new int[]{i, j, 0};
                } else if (building[i][j] == '*') {
                    fireBoard[i][j] = 0;
                    fireLocation.add(new int[]{i, j, 0});
                }
            }
        }
        return startPosition;
    }

    private void simulateEscape(int[] startPosition) {
        fireSimulate();
        humanSimulate(startPosition);
    }

    private void fireSimulate() {
        while (!fireLocation.isEmpty()) {
            int[] cur = fireLocation.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                int ntime = time + 1;
                if (isWithinBuilding(nx, ny) && (building[nx][ny] == '.' || building[nx][ny] == '@') && fireBoard[nx][ny] == -1) {
                    fireBoard[nx][ny] = ntime;
                    fireLocation.offer(new int[]{nx, ny, ntime});
                }
            }
        }
    }

    private void humanSimulate(int[] startPosition) {
        int startX = startPosition[0];
        int startY = startPosition[1];
        humanLocation.offer(startPosition);
        isVisited[startX][startY] = true;

        while (!humanLocation.isEmpty()) {
            int[] cur = humanLocation.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                int ntime = time + 1;

                if (isOutOfBuilding(nx, ny)) {
                    result = Math.min(result, ntime);
                    return;
                }

                if (isWithinBuilding(nx, ny) && building[nx][ny] == '.' && (fireBoard[nx][ny] > ntime || fireBoard[nx][ny] == -1) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    humanLocation.offer(new int[]{nx, ny, ntime});
                }
            }
        }
    }

    private boolean isOutOfBuilding(int x, int y) {
        return x < 0 || x >= building.length || y < 0 || y >= building[x].length;
    }

    private boolean isWithinBuilding(int x, int y) {
        return 0 <= x && x < building.length && 0 <= y && y < building[x].length;
    }
}

