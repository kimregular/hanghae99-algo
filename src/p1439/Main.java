package p1439;

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

    public static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String target) {
        StringTokenizer st1 = new StringTokenizer(target, "0");
        StringTokenizer st2 = new StringTokenizer(target, "1");

        return Math.min(st1.countTokens(), st2.countTokens());
    }
}