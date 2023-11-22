package p1427;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[] digits = new int[10];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long target = Long.parseLong(br.readLine());
            while (target > 0) {
                int tmp = (int) (target % 10);
                digits[tmp]++;
                target /= 10;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                int repeatNum = digits[i];
                for (int j = 0; j < repeatNum; j++) {
                    result.append(i);
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
