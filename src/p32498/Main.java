package p32498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int answer = 0;
            int len = Integer.parseInt(br.readLine());

            for (int i = 0; i < len; i++) {
                int target = Integer.parseInt(br.readLine());
                if(target % 2 != 0) answer++;
            }

            System.out.println(answer);
            return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
