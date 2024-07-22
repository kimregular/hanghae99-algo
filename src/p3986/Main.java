package p3986;

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

    int result = 0;

    public int solution(String[] targets) {
        for(String target : targets){
           if(isGoodWord(target)) result++;
        }
        return result;
    }

    private boolean isGoodWord(String target) {
        Deque<Character> stk = new ArrayDeque<>();

        for (char c : target.toCharArray()) {
            if (stk.isEmpty() || stk.peekLast() != c) {
                stk.offerLast(c);
            }else if(stk.peekLast() == c){
                stk.pollLast();
            }
        }

        return stk.isEmpty();
    }
}