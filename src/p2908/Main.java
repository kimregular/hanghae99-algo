package p2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num1;
    static int num2;

    static int intReverse(int num) {
        int result = 0;

        while (num > 0) {
            result = result * 10 +  num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

        num1 = intReverse(num1);
        num2 = intReverse(num2);

        if (num1 > num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }

        br.close();
    }
}
