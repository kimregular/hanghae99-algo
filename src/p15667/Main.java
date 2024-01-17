package p15667;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            Solution s = new Solution(target);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int target;

    public Solution(int target) {
        this.target = target;
    }

    public long solution() {
        for (int i = 1; i <= 10101; i++) {
            if (func(i) == target) {
                return i;
            }
        }
        return -1;
    }
    private long func(int num) {
        return 1 +  num  + ((long) num * num);
    }
}