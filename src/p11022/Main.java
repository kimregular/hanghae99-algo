package p11022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int nums;
    public static int num1;
    public static int num2;


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p11022/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = Integer.parseInt(br.readLine());

        for (int i = 0; i < nums; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            System.out.printf("Case #%d: %d + %d = %d\n", i+1, num1, num2, num1 + num2);
        }

        br.close();
    }
}
