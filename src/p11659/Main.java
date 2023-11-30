package p11659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfDigits = Integer.parseInt(st.nextToken());
            int TEST_CASE = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[numOfDigits + 1];
            arr[0] = 0;
            for (int i = 1; i < numOfDigits + 1; i++) {
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < TEST_CASE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                int result = arr[end] - arr[start - 1];

                bw.write(String.valueOf(result));
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
