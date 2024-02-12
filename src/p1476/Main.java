package p1476;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());

        return new int[]{earth, sun, moon};
    }
}

class Solution {

    public int solution(int[] date) {
        Calculator c = new Calculator(date);
        return c.getAnswer();
    }

    private class Calculator {

        int earth;
        int sun;
        int moon;

        int answer = 1;

        public Calculator(int[] date) {
            this.earth = date[0];
            this.sun = date[1];
            this.moon = date[2];
        }

        public int getAnswer() {
            calc();
            return this.answer;
        }

        private void calc() {
            int e = 1;
            int s = 1;
            int m = 1;

            while (!checkData(e, s, m)) {

                e++;
                if (e > 15) e = 1;
                s++;
                if (s > 28) s = 1;
                m++;
                if (m > 19) m = 1;
                this.answer++;
            }
        }

        private boolean checkData(int e, int s, int m) {
            return this.earth == e && this.sun == s && this.moon == m;
        }
    }
}
