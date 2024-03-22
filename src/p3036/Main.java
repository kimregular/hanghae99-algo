package p3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int key = nums[0];
        int[] wheels = Arrays.copyOfRange(nums, 1, nums.length);
        return getAnswer(key, wheels);
    }

    private String getAnswer(int key, int[] wheels) {
        StringBuilder answer = new StringBuilder();
        for (int wheel : wheels) {
            int divider = getGCD(key, wheel);
            answer.append(key / divider).append("/").append(wheel / divider).append("\n");
        }
        return answer.toString();
    }

    private int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}
