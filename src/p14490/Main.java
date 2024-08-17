package p14490;

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
        String[] tokens = br.readLine().split(":");
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return new int[]{num1, num2};
    }
}

class Solution {

    public String solution(int[] nums) {
        int GDC = getGDC(Math.max(nums[0], nums[1]), Math.min(nums[0], nums[1]));
        return nums[0] / GDC + ":" + nums[1] / GDC;
    }

    private int getGDC(int bigger, int smaller) {
        if(smaller == 0) return bigger;
        return getGDC(smaller, bigger % smaller);
    }
}