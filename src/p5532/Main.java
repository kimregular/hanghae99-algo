package p5532;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int vacation;
    static int math;
    static int kor;

    static int mathCapa;
    static int korCapa;

    static int getFree(int vacation, int kor, int math, int korCapa, int mathCapa) {
        int korDone = (kor % korCapa == 0) ? kor / korCapa : kor / korCapa + 1;
        int mathDone = (math % mathCapa == 0) ? math / mathCapa : math / mathCapa + 1;

        int workDay = (korDone - mathDone >= 0) ? korDone : mathDone;

        return vacation - workDay;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p5532/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vacation = Integer.parseInt(br.readLine());
        kor = Integer.parseInt(br.readLine());
        math = Integer.parseInt(br.readLine());
        korCapa = Integer.parseInt(br.readLine());
        mathCapa = Integer.parseInt(br.readLine());

        System.out.println(getFree(vacation, kor, math, korCapa, mathCapa));

        br.close();
    }
}
