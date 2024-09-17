package p1270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int testCases = Integer.parseInt(br.readLine());
            Solution s = new Solution();

            while (testCases-- > 0) {
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        long[] result = new long[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public String solution(long[] soldiers) {
        long candidate = 0;
        int cnt = 0;

        for (long soldier : soldiers) {
            if (cnt == 0) {
                candidate = soldier;
                cnt = 1;
            }

            if (candidate == soldier) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int winner = 0;
        for (long soldier : soldiers) {
            if (candidate == soldier) {
                winner++;
            }
        }

        if (winner > soldiers.length / 2) {
            return "" + candidate;
        } else {
            return "SYJKGW";
        }
    }
}
