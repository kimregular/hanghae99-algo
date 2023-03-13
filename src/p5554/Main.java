package p5554;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int total = 0;
    static int result;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p5554/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            total += Integer.parseInt(br.readLine());
        }

        System.out.println(total/60);
        System.out.println(total%60);

        br.close();
    }
}
