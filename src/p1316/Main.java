package p1316;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public int solution(String[] targets) {
        int cnt = 0;

        for (String target : targets) {
            if(isGroupWord(target)) cnt++;
        }
        return cnt;
    }

    private boolean isGroupWord(String target) {
        boolean[] check = new boolean[26];
        int prev = 0;

        for (int i = 0; i < target.length(); i++) {
            int now = target.charAt(i);

            if (now != prev) {
                if (check[now - 'a']) {
                    return false;
                } else {
                    check[now - 'a'] = true;
                    prev = now;
                }
            }
        }
        return true;
    }
}
