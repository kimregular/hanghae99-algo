package p1065;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            Solution s = new Solution(target);
            System.out.println(s.solution());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int target;

    public Solution(int target) {
        this.target = target;
    }

    public int solution() {
        int result = 0;

        for (int i = 1; i < this.target + 1; i++) {
            if (isHanSoo(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isHanSoo(int num) {
        if(num < 10) return true;

        String[] numArray = String.valueOf(num).split("");

        int equalDiffer = Integer.parseInt(numArray[0]) - Integer.parseInt(numArray[1]);

        for (int i = 0; i < numArray.length - 1; i++) {
            int num1 = Integer.parseInt(numArray[i]);
            int num2 = Integer.parseInt(numArray[i + 1]);

            if (num1 - num2 != equalDiffer) {
                return false;
            }
        }
        return true;
    }
}