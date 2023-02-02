package 지뢰탐지가필요;

import java.util.Arrays;

public class Main {
    public char[][] solution(int N, char[][] ary) {
        int[] x = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] y = {0, 0, 1, -1, 1, -1, 1, -1};


        char[][] answer = new char[N][N];

        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {
                if (ary[i][j] == '.') {
                    int tmp = 0;

                } else {
                    answer[i][j] = ary[i][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
//        int N = 5;
        int N = 4;
        char[][] chars={{'2', '.', '.', '.',},
                        {'.', '.', '9', '.'},
                        {'.', '3', '.', '2'},
                        {'.', '4', '.', '.'}};
        System.out.println(Arrays.deepToString(method.solution(N, chars)));
    }
}
