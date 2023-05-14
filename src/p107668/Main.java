package p107668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int month;

    static int day;

    static String getSpecial(int month, int day) {
        if (month == 1) {
            return "Before";
        } else if (month > 2) {
            return "After";
        } else {
            if (day < 18) {
                return "Before";
            } else if (day == 18) {
                return "Special";
            } else {
                return "After";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        month = Integer.parseInt(br.readLine());
        day = Integer.parseInt(br.readLine());
        System.out.println(getSpecial(month, day));

        br.close();
    }
}
