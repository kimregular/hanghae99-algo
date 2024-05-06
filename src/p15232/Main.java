package p15232;

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
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        return new int[]{num1, num2};
    }
}

class Solution{

    public String solution(int[] nums) {
        int num1 = nums[0];
        int num2 = nums[1];

        String stars = "*".repeat(num2);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < num1; i++) {
            answer.append(stars).append("\n");
        }
        return answer.toString();
    }
}