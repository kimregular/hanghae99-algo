package p1977;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num1 = Integer.parseInt(br.readLine());
            int num2 = Integer.parseInt(br.readLine());

            Solution s = new Solution(num1, num2);
            int[] answer = s.solution();

            if (answer.length == 0) {
                System.out.println(-1);
            } else {
                for (int x : answer) {
                    System.out.println(x);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int num1;
    int num2;

    public Solution(int num1, int num2) {
        this.num1 = Math.min(num1, num2);
        this.num2 = Math.max(num1, num2);
    }

    public int[] solution() {
        ArrayList<Integer> arr = new ArrayList<>();
        int total = 0;
        for (int i = this.num1; i <= this.num2; i++) {
            int tmp = (int) Math.sqrt(i);

            if (tmp * tmp == i) {
                arr.add(i);
                total += i;
            }
        }
        if (arr.isEmpty()) return new int[]{};

        return new int[]{total, arr.get(0)};
    }
}
