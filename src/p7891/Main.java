package p7891;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int nums;

    public static long num1;
    public static long num2;

    public static void cal(long num1, long num2) {
        System.out.println(num1 + num2);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p7891/text.txt"));

        nums = Integer.parseInt(br.readLine());
        for (int i = 0; i < nums; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            cal(num1, num2);
        }

        br.close();
    }
}
