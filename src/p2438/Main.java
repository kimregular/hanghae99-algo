package p2438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static void stars(int num) {
        for (int i = 0; i < num; i++) {
            String tmp = "*".repeat(i+1);
            System.out.print(tmp+"\n");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        stars(num);
        br.close();
    }
}
