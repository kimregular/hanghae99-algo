package p15726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double num1 = Integer.parseInt(st.nextToken());
        double num2 = Integer.parseInt(st.nextToken());
        double num3 = Integer.parseInt(st.nextToken());

        Solution s = new Solution();

        System.out.println(s.solution(num1, num2, num3));

        br.close();
    }
}

class Solution{

    public int solution(double num1, double num2, double num3){
        int answer1 = (int) (num1 / num2 * num3);
        int answer2 = (int) (num1 * num2 / num3);



        return Math.max(answer1, answer2);
    }
}
