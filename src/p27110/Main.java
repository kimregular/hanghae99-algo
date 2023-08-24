package p27110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.solution(n, h, g, y));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Solution {

    public int solution(int n, int h, int g, int y) {
        int answer = 0;

        answer += n - h >= 0 ? h : n;
        answer += n - g >= 0 ? g : n;
        answer += n - y >= 0 ? y : n;

        return answer;
    }
}
