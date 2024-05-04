package p10804;

import java.io.*;
import java.util.Arrays;

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
        int[][] input = new int[10][2];

        for (int i = 0; i < input.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[1]);
            input[i][0] = num1;
            input[i][1] = num2;
        }

        return input;
    }
}

class Solution {

    int[] field = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public String solution(int[][] input) {
        for (int[] i : input) {
            shiftNums(i);
        }

        return getAnswer(field);
    }

    private String getAnswer(int[] arr) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < arr.length; i++){
            answer.append(arr[i]).append(" ");
        }

        return answer.toString();
    }

    private void shiftNums(int[] arr) {
        int[] copyArr = Arrays.copyOfRange(field, arr[0], arr[1] + 1);
        int idx = copyArr.length - 1;
        for (int i = arr[0]; i <= arr[1]; i++) {
            field[i] = copyArr[idx--];
        }
    }
}