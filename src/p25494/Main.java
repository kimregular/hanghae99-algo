package p25494;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            Solution s = new Solution();

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                System.out.println(s.solution(a, b, c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class Solution {

    public int solution(int a, int b, int c) {
        int answer = 0;
        for (int i = 1; i < 61; i++) {
            for (int j = 1; j < 61; j++) {
                for (int k = 1; k < 61; k++) {
                    if (i <= a) {
                        if (j <= b) {
                            if (k <= c) {
                                int x = i % j;
                                int y = i % k;
                                int z = j % k;
                                if (x == y && y == z && x == z) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
