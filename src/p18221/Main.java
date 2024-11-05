package p18221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] map) {
        int len = map.length;

        int[] student = new int[2];
        int[] professor = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map[i][j] == 5) professor = new int[]{i, j};
                else if (map[i][j] == 2) student = new int[]{i, j};
            }
        }
        return isDistanceEnough(student, professor) && hasThreeFriend(map, student, professor) ? 1 : 0;
    }

    private boolean isDistanceEnough(int[] student, int[] professor) {
        return Math.pow(student[0] - professor[0], 2) + Math.pow(student[1] - professor[1], 2) >= 25;
    }

    private boolean hasThreeFriend(int[][] map, int[] student, int[] professor) {
        int startX = Math.min(student[0], professor[0]);
        int endX = Math.max(student[0], professor[0]);
        int startY = Math.min(student[1], professor[1]);
        int endY = Math.max(student[1], professor[1]);

        int friends = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (map[i][j] == 1) {
                    friends++;
                }
                if (friends >= 3) return true;
            }
        }
        return false;
    }
}