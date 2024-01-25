package p1935;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Solution s = new Solution();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());

            char[] postfix = br.readLine().toCharArray();

            double[] nums = new double[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Double.parseDouble(br.readLine());
            }

            System.out.printf("%.2f", s.solution(postfix, nums));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public double solution(char[] postfix, double[] nums) {
        Stack<Double> numStck = new Stack<>();

        for (char x : postfix) {
            if ('A' <= x && x <= 'Z') {
                numStck.push(nums[x - 'A']);
            } else {
                double num2 = numStck.pop();
                double num1 = numStck.pop();
                numStck.push(operation(num1, num2, x));
            }
        }
        return numStck.pop();
    }

    private double operation(double num1, double num2, char oper) {
        return switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

}