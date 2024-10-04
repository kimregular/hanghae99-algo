package p15719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] readInput(BufferedReader br) throws IOException {
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

    public int solution(int[] nums) {
        int[] memo = new int[nums.length];
        for (int num : nums) {
            if(memo[num] != 0) return num;
            else memo[num]++;
        }
        return -1;
    }
}