package p1526;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int limit = Integer.parseInt(br.readLine());

            Solution s = new Solution(limit);
            System.out.println(s.solution());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int limit;

    public Solution(int limit) {
        this.limit = limit;
    }

    public int solution() {
        for (int i = this.limit; i >= 1; i--) {
            if (isTheNum(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isTheNum(int num) {
        while (num > 0) {
            int theNum = num % 10;
            num /= 10;
            if (theNum % 10 != 7 && theNum % 10 != 4) {
                return false;
            }
        }
        return true;
    }
}