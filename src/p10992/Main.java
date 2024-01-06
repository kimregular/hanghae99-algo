package p10992;

import java.io.*;
import java.util.*;

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

        for (int i = 0; i < this.num - 1; i++) {
            for (int j = 0; j < this.num - i - 1; j++) {
                result.append(" ");
            }
            result.append("*");

            for (int j = 0; j < 2 * i - 1; j++) {
                result.append(" ");
            }
            if (i != 0) {
                result.append("*").append("\n");
            } else {
                result.append("\n");
            }
        }

        result.append(("*").repeat(2 * this.num - 1));
        return result.toString();
    }
}