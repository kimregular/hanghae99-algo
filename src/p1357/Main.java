package p1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int num1;
    static int num2;


    static int getRev(int num) {
        int result = 0;

        while (num > 0) {
            result *= 10;
            result += num % 10;
            num /= 10;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

        System.out.println(getRev(getRev(num1) + getRev(num2)));



        br.close();
    }
}
