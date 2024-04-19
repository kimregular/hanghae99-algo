package p4948;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();

            int target;
            while ((target = Integer.parseInt(br.readLine())) != 0) {
                s.getPrimeNums(target);
            }

            System.out.println(s.answer.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution{

    int[] field = new int[123_457 * 2];

    StringBuilder answer = new StringBuilder();

    public Solution() {
        for (int i = 2; i < field.length; i++) {
            if (field[i] == 0) {
                for (int j = i + i; j < field.length; j += i) {
                    field[j] = 1;
                }
            }
        }
    }

    public void getPrimeNums(int target) {
        int result = 0;
        for (int i = target + 1; i <= target * 2; i++) {
            if (field[i] == 0) result++;
        }
        this.answer.append(result).append("\n");
    }
}