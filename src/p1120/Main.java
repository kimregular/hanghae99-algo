package p1120;

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

    private static String[] getInput(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}

class Solution {

    public int solution(String[] targets) {
        String word1 = targets[0];
        String word2 = targets[1];
        if(word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        int min = 51;
        for(int i=0;i<=word1.length()-word2.length();i++) {
            int num = 0;
            for(int j=0;j<word2.length();j++) {
                if(word1.charAt(j+i)!=word2.charAt(j))
                    num++;
            }
            min = Math.min(min,num);
        }
        return min;
    }
}