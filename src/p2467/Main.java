package p2467;

import java.io.*;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return nums;
    }
}

class Solution {

    public String solution(int[] nums) {
        int curValue = Integer.MAX_VALUE;
        int lp = 0;
        int rp = nums.length - 1;

        int answerA = 0;
        int answerB = 0;

        while (lp < rp) {
            if (Math.abs(curValue) > Math.abs(nums[lp] + nums[rp])) {
                curValue = nums[lp] + nums[rp];
                answerA = nums[lp];
                answerB = nums[rp];
            }
            if(nums[lp] + nums[rp] < 0) lp++;
            else rp--;
        }

        return answerA + " " + answerB;
    }
}