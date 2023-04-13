package p1284;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean flag = true;
    static int num;

    static int getLen(int num) {
        int len = 0;
        int idx = 0;
        int digit = 0;
        while (num > 0) {
            digit = num % 10;

            if (digit == 1) {
                len += 2;
            } else if (digit == 0) {
                len += 4;
            } else {
                len += 3;
            }
            num /= 10;
            idx++;
        }

        len += idx - 1; // 숫자간 간격 1cm
        len += 2; // 양 끝 1cm

        return len;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1284/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                flag = false;
            } else {
                System.out.println(getLen(num));
            }

        }

        br.close();
    }
}
