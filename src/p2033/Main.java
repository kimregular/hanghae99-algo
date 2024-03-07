package p2033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public String solution(String target) {
        int[] arr = new int[target.length()];
        for (int i = 0; i < target.length(); i++) {
            arr[target.length()-i-1] = target.charAt(i) - '0';
        }

        for (int i = 0; i < arr.length-1; i++) {
            arr[i+1] += arr[i]>=5?1:0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[arr.length-1]);
        for (int i = 0; i < target.length()-1; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}
