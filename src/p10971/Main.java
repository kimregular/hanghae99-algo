package p10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int len = Integer.parseInt(br.readLine());

        int[][] cityMap = new int[len][len];

        for (int i = 0; i < cityMap.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < cityMap[i].length; j++) {
                cityMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return cityMap;
    }
}

class Solution {

    public int solution(int[][] board) {
        PermutationResolver pr = new PermutationResolver(board);
        return pr.getResult();
    }

    private class PermutationResolver {

        int[][] board;
        int group;
        int[] permutated;
        boolean[] isUsed;
        int result = Integer.MAX_VALUE;

        public PermutationResolver(int[][] board) {
            this.board = board;
            this.permutated = new int[board.length];
            this.group = board.length;
            this.isUsed = new boolean[board.length];
        }

        public int getResult() {
            permutate(0);
            return this.result;
        }

        private void permutate(int cnt) {
            if (cnt == this.group) {
                savePermutated();
                return;
            }

            for (int i = 0; i < this.group; i++) {
                if(this.isUsed[i]) continue;

                this.isUsed[i] = true;
                this.permutated[cnt] = i;
                permutate(cnt + 1);
                this.isUsed[i] = false;
            }
        }

        private void savePermutated() {
            boolean flag = true;

            int cost = 0;

            for (int i = 0; i < this.permutated.length - 1; i++) {
                int x = this.permutated[i];
                int y = this.permutated[i + 1];
                if(this.board[x][y] == 0){
                    flag = false;
                    break;
                }

                cost += this.board[x][y];
            }

            if (this.board[this.permutated[this.permutated.length - 1]][this.permutated[0]] == 0) {
                flag = false;
            }
            cost += this.board[this.permutated[this.permutated.length - 1]][this.permutated[0]];

            if (flag) {
                this.result = Math.min(this.result, cost);
            }
        }
    }
}