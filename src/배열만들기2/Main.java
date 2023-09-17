package 배열만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int l = 10;
            int r = 20;

            Solution s = new Solution();
            System.out.println(Arrays.toString(s.solution(l, r)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> lst = new ArrayList<>();

        for (int i = l; i < r + 1; i++) {
            String tmp = i + "";
            int cnt = 0;
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '0' || tmp.charAt(j) == '5') {
                    cnt++;
                }
            }

            if (cnt == tmp.length()) {
                lst.add(i);
            }
        }

        return lst.isEmpty() ? new int[]{-1} : lst.stream().mapToInt(a -> a).toArray();
    }
}