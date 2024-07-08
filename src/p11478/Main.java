package p11478;

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

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String target) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < target.length(); i++) {
            for (int j = i + 1; j <= target.length(); j++) {
                set.add(target.substring(i, j));
            }
        }
        return set.size();
    }
}