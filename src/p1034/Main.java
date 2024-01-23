package p1034;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfCD = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                smallest = Math.min(smallest, num);
                biggest = Math.max(biggest, num);
            }

            System.out.println(smallest * biggest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
