package p10991;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            Solution s = new Solution(num);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int num;

    public Solution(int num) {
        this.num = num;
    }

    public String solution() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num - i - 1; j++) {
                result.append(" ");
            }
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                if (j % 2 == 0) {
                    result.append("*");
                } else {
                    result.append(" ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}