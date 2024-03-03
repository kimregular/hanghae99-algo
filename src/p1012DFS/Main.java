package p1012DFS;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int numOfCabbages = Integer.parseInt(st.nextToken());

        int[][] field = new int[x][y];
        for (int i = 0; i < numOfCabbages; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            field[cx][cy] = 1;
        }
        return field;
    }
}

class Solution {

    public int solution(int[][] field) {
        CabbageFinder cb = new CabbageFinder(field);
        return cb.explore();
    }

    class CabbageFinder {

        int[][] field;
        boolean[][] hasCheck;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int numOfBugs = 0;

        public CabbageFinder(int[][] field) {
            this.field = field;
            this.hasCheck = new boolean[field.length][field[0].length];
        }

        public int explore() {
            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[i].length; j++) {
                    if (this.field[i][j] == 1 && !hasCheck[i][j]) {
                        this.numOfBugs++;
                        searchDFS(i, j);
                    }
                }
            }
            return this.numOfBugs;
        }

        private void searchDFS(int i, int j) {
            this.hasCheck[i][j] = true;
            for (int[] direction : directions) {
                int nx = i + direction[0];
                int ny = j + direction[1];

                if (isWithinField(nx, ny) && isCabbageField(nx, ny) && !this.hasCheck[nx][ny]) {
                    searchDFS(nx, ny);
                }
            }
        }

        private boolean isWithinField(int x, int y) {
            return x >= 0 && x < this.field.length && y >= 0 && y < this.field[x].length;
        }

        private boolean isCabbageField(int x, int y) {
            return this.field[x][y] == 1;
        }
    }
}
