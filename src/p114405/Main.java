package p114405;

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

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public String solution(String target) {
        return isValid(target) ? "YES" : "NO";
    }

    private boolean isValid(String target) {
        target = target.replaceAll("pi|ka|chu", "");
        return target.isEmpty();
    }
}