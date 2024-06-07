package p31403;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        return new int[]{a, b, c};
    }
}

class Solution {

    public String solution(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        StringBuilder answer = new StringBuilder();
        answer.append(integerOper(a, b, c)).append("\n");
        answer.append(stringOper(a, b, c));
        return answer.toString();
    }

    private int integerOper(int a, int b, int c) {
        return a + b - c;
    }

    private int stringOper(int a, int b, int c) {
        String tempA = "" + a + b;
        return Integer.parseInt(tempA) - c;
    }
}