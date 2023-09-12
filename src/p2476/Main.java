package p2476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());
            Solution s = new Solution();

            StringTokenizer st;

            int MAX_PRICE = 0;

            for (int i = 0; i < TEST_CASE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                MAX_PRICE = Math.max(MAX_PRICE, s.solution(a, b, c));
            }

            System.out.println(MAX_PRICE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {



    public int solution(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + (a * 1000);
        } else if (a == b) {
            return 1000 + (a * 100);
        } else if (a == c) {
            return 1000 + (a * 100);
        } else if (b == c) {
            return 1000 + (b * 100);
        } else {
            int result = Math.max(a, b);
            return Math.max(result, c) * 100;
        }
    }
}
