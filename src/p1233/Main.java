package p1233;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            System.out.println(getMode(num1, num2, num3));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMode(int num1, int num2, int num3) {
        Map<Integer, Integer> cases = new HashMap<>();

        for (int x = 1; x <= num1; x++) {
            for (int y = 1; y <= num2; y++) {
                for (int z = 1; z <= num3; z++) {
                    int caseOfNum = x + y + z;

                    cases.put(caseOfNum, cases.getOrDefault(caseOfNum, 0) + 1);
                }
            }
        }
        int maxValue = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> el : cases.entrySet()) {
            if (el.getValue() > maxValue) {
                maxValue = el.getValue();
                result = el.getKey();
            }
        }

        return result;
    }
}
