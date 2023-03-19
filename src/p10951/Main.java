package p10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num1;
    static int num2;

    static boolean flag = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                num1 = Integer.parseInt(st.nextToken());
                num2 = Integer.parseInt(st.nextToken());
                System.out.println(num1 + num2);
            } catch (Exception ex) {
                flag = false;
            }
        }

        br.close();
    }
}
