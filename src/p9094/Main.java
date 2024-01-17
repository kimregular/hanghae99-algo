package p9094;

import java.io.*;
import java.util.*;

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                System.out.println(s.solution(n, m));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int n, int m) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double testNum = (double) ((i * i) + (j * j) + m) /(i * j);
                if( testNum == (int) testNum ) answer++;
            }
        }
        return answer;
    }
}