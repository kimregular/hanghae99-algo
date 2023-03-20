package p11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split("");
        for (String s : st) {
            cnt += Integer.parseInt(s);
        }
        System.out.println(cnt);

        br.close();
    }
}
