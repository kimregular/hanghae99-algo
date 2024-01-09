package p1075;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long targetNum = Long.parseLong(br.readLine());
            long divideNum = Long.parseLong(br.readLine());

            Solution s = new Solution(targetNum, divideNum);
            System.out.println(s.solution());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    long targetNum;
    long divideNum;

    public Solution(long targetNum, long divideNum) {
        this.targetNum = targetNum;
        this.divideNum = divideNum;
    }
    
    public String solution() {
        StringBuilder num = new StringBuilder(String.valueOf(this.targetNum));
        num.setLength(num.length() - 2);

        StringBuilder postFix = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                postFix.append("0").append(i);
            } else {
                postFix.append(i);
            }

            long testNum = Long.parseLong(num.toString() + postFix.toString());

            if (isZeroDivide(testNum)) {
                return postFix.toString();
            }
            postFix.setLength(0);
        }

        return "-1";
    }

    private boolean isZeroDivide(long num) {
        return num % this.divideNum == 0;
    }
}