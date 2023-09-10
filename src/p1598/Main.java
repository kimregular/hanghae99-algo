package p1598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.solution(start, end));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int start, int end) {
        start--;
        end--;

        int xStart = start / 4;
        int xEnd = end / 4;

        int x = Math.abs(xStart - xEnd);

        int yStart = start % 4;
        int yEnd = end % 4;

        int y = Math.abs(yStart - yEnd);

        return x + y;
    }
}