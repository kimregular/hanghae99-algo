package p2386;

import java.io.*;

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] input = br.readLine().split(" ");

                if(input[0].equals("#")) break;

                System.out.println(s.solution(input));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public String solution(String[] input) {
        char target = input[0].charAt(0);
        int result = 0;

        for (int i = 1; i < input.length; i++) {
            for (char x : input[i].toCharArray()) {
                char tmp = toBiggerCase(x);

                if (tmp == target) {
                    result++;
                }
            }
        }

        return target + " " + result;
    }

    private char toBiggerCase(char c) {
        if(c < 'a') return (char) (c + 32);
        return c;
    }
}