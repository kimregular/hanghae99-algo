package p1924;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            int totalDays = 0;

            for (int i = 0; i < month - 1; i++) {
                totalDays += months[i];
            }

            totalDays += day;



            System.out.println(weekDays[totalDays % 7]);
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
