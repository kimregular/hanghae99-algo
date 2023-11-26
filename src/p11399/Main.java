package p11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfDigits = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            arr.sort(Comparator.naturalOrder());

            int lastMinute = 0;
            int totalMinute = 0;
            for (Integer ints : arr) {
                lastMinute += ints;
                totalMinute += lastMinute;
            }

            System.out.println(totalMinute);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
