package p4344;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p4344/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] st = br.readLine().split(" ");
            mean = getMean(st);
            ratio = getRatio(st, mean);
            System.out.println(getThree(ratio)+"%");
        }

        br.close();
    }

    static int num;

    static int mean;

    static double ratio;


    static int getMean(String[] strings) {
        int total = 0;

        for (int i = 1; i < strings.length; i++) {
            total += Integer.parseInt(strings[i]);
        }

        return total / Integer.parseInt(strings[0]);
    }

    static double getRatio(String[] strings, int mean) {
        int cnt = 0;

        for (int i = 1; i < strings.length; i++) {
            if (Integer.parseInt(strings[i]) > mean) {
                cnt++;
            }
        }

        return cnt / Double.parseDouble(strings[0]) * 100;
    }

    static String getThree(double number) {
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(number);
    }
}
