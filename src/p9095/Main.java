package p9095;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());

            for (int i = 0; i < len; i++) {
                Solution s = new Solution();
                System.out.println(s.solution(Integer.parseInt(br.readLine())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int target) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        lst.add(1);
        lst.add(2);
        lst.add(4);

        for (int i = 4; i <= target; i++) {
            int tmp = lst.get(i - 3) + lst.get(i - 2) + lst.get(i - 1);
            lst.add(tmp);
        }

        return lst.get(target);
    }
}