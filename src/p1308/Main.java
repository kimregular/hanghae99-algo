package p1308;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int[] input = new int[3];
        input[0] = Integer.parseInt(tokens[0]);
        input[1] = Integer.parseInt(tokens[1]);
        input[2] = Integer.parseInt(tokens[2]);

        return input;
    }
}


class Solution {

    public String solution(int[] startDate, int[] endDate) {
        LocalDate today = LocalDate.of(startDate[0], startDate[1], startDate[2]);
        LocalDate targetDay = LocalDate.of(endDate[0], endDate[1], endDate[2]);

        return getAnswer(today, targetDay);
    }

    private String getAnswer(LocalDate today, LocalDate targetDay) {
        if(targetDay.isAfter(today.plusYears(1000)) ||targetDay.isEqual(today.plusYears(1000))) return "gg";
        return "D-" + ChronoUnit.DAYS.between(today, targetDay);
    }
}