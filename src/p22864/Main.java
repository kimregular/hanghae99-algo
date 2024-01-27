package p22864;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(s.solution(a, b, c, m));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int a, int b, int c, int m) {
        int count = 0;

        int answer = 0;
        int fatigue = 0;

        while (count != 24) {
            if (fatigue + a <= m) {
                fatigue += a;
                answer += b;
            } else {
                fatigue -= c;
                if(fatigue < 0) fatigue = 0;
            }
            count++;
        }
        return answer;
    }
}