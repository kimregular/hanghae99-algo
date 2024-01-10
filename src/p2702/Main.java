package p2702;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                for (int x : getAnswer(num1, num2)) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getAnswer(int num1, int num2) {
        int bigger = Math.max(num1, num2);
        int smaller = Math.min(num1, num2);
        return new int[]{LCM(bigger, smaller), GCD(bigger, smaller)};
    }
    private static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        return GCD(num2, num1 % num2);
    }

    private static int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }
}
