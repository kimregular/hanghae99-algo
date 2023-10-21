package p1547;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] cups = new int[4];
        cups[1] = 1;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int tmp = cups[x];
                cups[x] = cups[y];
                cups[y] = tmp;
            }

            for (int i = 0; i < cups.length; i++) {
                if (cups[i] == 1) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
