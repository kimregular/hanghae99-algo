package p1356;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(br.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public String solution(String num) {
        for (int i = 1; i < num.length(); i++) {
            String left = num.substring(0, i);
            int leftNum = toInteger(left);

            String right = num.substring(i);;
            int rightNum = toInteger(right);

            if(leftNum == rightNum) return "YES";
        }
        return "NO";
    }

    private int toInteger(String str) {
        int result = 1;
        for (char x : str.toCharArray()) {
            result *= (x - '0');
        }
        return result;
    }
}