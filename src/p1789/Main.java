package p1789;

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

    private static long getInput(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
}

class Solution {

    public long solution(long target) {

        long num = target;
        long sum = 0;
        int count = 0;

        for(int i=1; ; i++) {
            if(sum > num) break;
            sum += i;
            count ++;
        }
        return count - 1;
    }
}