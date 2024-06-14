package p1541;

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

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String input) {
        int answer = 0;
        boolean isFirstAdd = true;
        String[] numsWithoutMinus = input.split("-");

        for (String next : numsWithoutMinus) {
            if (isFirstAdd) {
                answer += getAddedNum(next);
                isFirstAdd = false;
            } else {
                answer -= getAddedNum(next);
            }
        }

        return answer;
    }


    private int getAddedNum(String input) {
        int result = 0;
        String[] nums = input.split("\\+");
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}