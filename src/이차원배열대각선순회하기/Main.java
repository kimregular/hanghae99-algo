package 이차원배열대각선순회하기;

public class Main {
    public static void main(String[] args) {

        int[][] board = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int k = 2;

        Solution s = new Solution();
        System.out.println(s.solution(board, k));

    }
}

class Solution {

    public int solution(int[][] board, int k) {

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i + j <= k) {
                    answer += board[i][j];
                }
            }
        }

        return answer;
    }
}
