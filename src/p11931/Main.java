package p11931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        int len = Integer.parseInt(br.readLine());

        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        return nums;
    }
}

class Solution {

    public String solution(int[] nums) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            answer.append(nums[i]).append("\n");
        }


        return answer.toString();
    }
}