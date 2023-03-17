package p8393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static int cnt = 0;

    static int calcSum(int num) {
        for (int i = 1; i < num+1; i++) {
            cnt += i;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        System.out.println(calcSum(num));
        br.close();
    }
}
