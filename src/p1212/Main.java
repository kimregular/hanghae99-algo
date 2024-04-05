package p1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    String[] octaPiece = {"000", "001", "010", "011", "100", "101", "110", "111"};


    public String solution(String octaStr) {
        if(octaStr.equals("0")) return "0";
        return getZeroRemovedResult(convertBinaryToOcta(octaStr));
    }

    private StringBuilder convertBinaryToOcta(String octaStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < octaStr.length(); i++) {
            result.append(octaPiece[octaStr.charAt(i) - '0']);
        }
        return result;
    }

    private String getZeroRemovedResult(StringBuilder sb) {
        while(sb.charAt(0) == '0') sb = new StringBuilder(sb.substring(1));
        return sb.toString();
    }
}
