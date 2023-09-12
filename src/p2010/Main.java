package p2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            int answer = 0;

            for (int i = 0; i < TEST_CASE; i++) {
                answer += Integer.parseInt(br.readLine());
            }

            answer -= TEST_CASE - 1;

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
