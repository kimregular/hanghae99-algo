package p25305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int len = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] arr = new int[len];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            System.out.println(arr[arr.length - limit]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
