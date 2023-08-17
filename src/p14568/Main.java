package p14568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int CANDY = Integer.parseInt(br.readLine());

            int answer = 0;

            for (int i = 0; i < CANDY + 1; i++) {
                for (int j = 0; j < CANDY + 1; j++) {
                    for (int k = 0; k < CANDY + 1; k++) {
                        if (i + j + k == CANDY) {
                            if (k >= j + 2) {
                                if (i != 0 && j != 0 && k != 0) {
                                    if (i % 2 == 0) {
                                        answer++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
