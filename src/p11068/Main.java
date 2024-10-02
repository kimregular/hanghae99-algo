package p11068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        return nums;
    }
}

class Solution {

    public String solution(int[] nums) {
        StringBuilder answer = new StringBuilder();
        for (int num : nums) {
            answer.append(isPalindrome(num)).append("\n");
        }
        return answer.toString();
    }

    private int isPalindrome(int num) {
        for (int i = 2; i < 65; i++) {
            List<Integer> target = getPalindrome(num, i);
            if(isValid(target)) return 1;
        }
        return 0;
    }

    private List<Integer> getPalindrome(int num, int radix) {
        List<Integer> palindromeCandidate = new ArrayList<>();
        while (num > 0) {
            palindromeCandidate.add(num % radix);
            num /= radix;
        }
        return palindromeCandidate;
    }


    private boolean isValid(List<Integer> target) {
        for (int i = 0; i < target.size() / 2; i++) {
            if(!Objects.equals(target.get(i), target.get(target.size() - 1 - i))) return false;
        }
        return true;
    }
}
