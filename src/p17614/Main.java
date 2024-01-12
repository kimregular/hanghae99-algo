package p17614;

import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            System.out.println(get369(num));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int get369(int num) {
        int result = 0;

        for (int i = 1; i <= num; i++) {
            int cur = i;

            while (cur > 0) {
                int testNum = cur%10;
                cur /= 10;

                if (testNum == 3 || testNum == 6 || testNum == 9) {
                    result++;
                }
            }
        }

        return result;
    }
}
