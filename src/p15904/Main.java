package p15904;

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
        String[] UCPC = {"U", "C", "P", "C"};
        int cnt = 0;

        for (String t : target.split("")) {
            if (UCPC[cnt].equals(t)) cnt++;
            if(cnt == 4) return "I love UCPC";
        }
        return "I hate UCPC";
    }
}