package p2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer num = Integer.MIN_VALUE;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (num < tmp) {
                num = tmp;
                idx = i+1;
            }
        }
        System.out.println(num);
        System.out.println(idx);
        br.close();
    }
}
