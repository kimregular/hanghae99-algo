package p9085;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder answer = new StringBuilder();

            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                int numOfDigits = Integer.parseInt(br.readLine());

                int total = 0;

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                while (st.hasMoreTokens()) {
                    total += Integer.parseInt(st.nextToken());
                }

                answer.append(total).append("\n");
            }

            System.out.println(answer);
            return;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
