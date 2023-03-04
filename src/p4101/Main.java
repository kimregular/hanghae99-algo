package p4101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int num1;
    public static int num2;

    public static String isBig(int num1, int num2) {
        if (num1 > num2) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            if (num1 == 0 && num2 == 0) {
                break;
            }
            System.out.println(isBig(num1, num2));
        }

    }
}
