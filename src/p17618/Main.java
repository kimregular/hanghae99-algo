package p17618;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            Solution s = new Solution(target);
            System.out.println(s.getWonderNum());

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

    public int getWonderNum() {
        int result = 0;
        for (int i = 1; i <= this.target; i++) {
            if(isWonder(i)) result++;
        }

        return result;
    }

    private boolean isWonder(int origin) {
        if(origin < 10) return true;

        int tmp = 0;
        int num = origin;
        while (num > 0) {
            tmp += num % 10;
            num /= 10;
        }

        return origin % tmp == 0;
    }
}