package p10419;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                int lectureLength = Integer.parseInt(br.readLine());
                answer.append(getMaxLateTime(lectureLength)).append("\n");
            }

            System.out.println(answer);
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getMaxLateTime(int time) {
        int maxLateTime = 0;
        for (int i = 0; i < time; i++) {
            int lateAndSkip = i + (i * i);

            if (lateAndSkip <= time) {
                maxLateTime = Math.max(maxLateTime, i);
            } else {
                return maxLateTime;
            }
        }
        return maxLateTime;
    }
}
