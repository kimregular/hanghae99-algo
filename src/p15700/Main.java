package p15700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.solution(N, M));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public long solution(long N, long M) {
        long width = N * M;

        return width / 2;
    }
}