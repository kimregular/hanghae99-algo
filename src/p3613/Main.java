package p3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        if(isInvalidTarget(target)) return "Error!";
        return convert(target);
    }

    private String convert(String target) {
        if(hasUnderbar(target)) return cToJava(target);
        return javaToC(target);
    }

    private String cToJava(String target) {
        StringTokenizer st = new StringTokenizer(target, "_");
        StringBuilder result = new StringBuilder();
        result.append(st.nextToken());
        while (st.hasMoreTokens()) {
            char[] word = st.nextToken().toCharArray();
            word[0] -= 32;
            result.append(word);
        }
        return result.toString();
    }

    private String javaToC(String target) {
        StringBuilder result = new StringBuilder();
        for (char c : target.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                result.append("_").append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private boolean isInvalidTarget(String target) {
        if(target.endsWith("_")) return true;
        if(target.startsWith("_")) return true;
        if(target.contains("__")) return true;
        if(hasBigAtFront(target)) return true;
        if(hasBigAndUnderbar(target)) return true;
        return false;
    }

    private boolean hasBigAtFront(String target) {
        char front = target.charAt(0);
        return 'A' <= front && front <= 'Z';
    }

    private boolean hasBigAndUnderbar(String target) {
        return hasBig(target) && hasUnderbar(target);
    }

    private boolean hasBig(String target) {
        for (char c : target.toCharArray()) {
            if('A' <= c && c <= 'Z') return true;
        }
        return false;
    }

    private boolean hasUnderbar(String target) {
        return target.contains("_");
    }
}