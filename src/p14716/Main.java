package p14716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);

        int[][] result = new int[x][y];
        for (int i = 0; i < result.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] banner) {
        CharacterFinder cf = new CharacterFinder(banner);
        return cf.getResult();
    }
}

class CharacterFinder {

    private final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private final int[][] banner;
    private final boolean[][] isChecked;
    private int result;

    public CharacterFinder(int[][] banner) {
        this.banner = banner;
        this.isChecked = new boolean[banner.length][banner[0].length];
        this.result = 0;
    }

    public int getResult() {
        findCharacter();
        return result;
    }

    private void findCharacter() {
        for (int i = 0; i < banner.length; i++) {
            for (int j = 0; j < banner[i].length; j++) {
                if (banner[i][j] == 1 && !isChecked[i][j]) {
                    result++;
                    explore(i, j);
                }
            }
        }
    }

    private void explore(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        isChecked[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinBanner(nx, ny) && banner[nx][ny] == 1 && !isChecked[nx][ny]) {
                    isChecked[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private boolean isWithinBanner(int x, int y) {
        return 0 <= x && x < banner.length && 0 <= y && y < banner[x].length;
    }

}