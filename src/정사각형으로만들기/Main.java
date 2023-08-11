package 정사각형으로만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] arr = {{57, 192, 534, 2}, {9, 345, 192, 999}};

        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.solution(arr)));
    }
}

class Solution {

    public int[][] solution(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        if (rows < cols) {
            return addRows(arr, cols - rows);
        }

        if (rows > cols) {
            return addCols(arr, rows - cols);
        }

        return arr;
    }

    private int[][] addCols(int[][] arr, int gap) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j < arr[i].length; j++) {
                answer.get(i).add(arr[i][j]);
            }
            for (int j = 0; j < gap; j++) {
                answer.get(i).add(0);
            }
        }

        return answer.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    private int[][] addRows(int[][] arr, int gap) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j < arr[i].length; j++) {
                answer.get(i).add(arr[i][j]);
            }
        }

        for (int i = 0; i < gap; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j < arr[0].length; j++) {
                answer.get(answer.size() - 1).add(0);
            }
        }

        return answer.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
