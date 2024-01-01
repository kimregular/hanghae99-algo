package p2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] order = {"E", "A", "B", "C", "D"};

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for (int i = 0; i < 3; i++) {
                int cnt = 0;
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (num == 0) {
                        cnt++;
                    }
                }
                System.out.println(order[cnt]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
