package p2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String star = " ".repeat(num - i - 1) + "*".repeat(i + 1);
            System.out.println(star);
        }
        br.close();
    }
}
