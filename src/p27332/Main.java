package p27332;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution(int day, int week) {
        int days = week * 7;

        if (day + days <= 30) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());
        int week = Integer.parseInt(br.readLine());

        Main s = new Main();
        System.out.println(s.solution(day, week));

        br.close();
    }
}
