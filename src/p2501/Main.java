package p2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int num;

    static int idx;

    static List<Integer> arr = new ArrayList<>();

    static int divisor(int num, int idx) {

        for (int i = 1; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                arr.add(i);
            }
        }
        arr.add(num);

        return arr.get(idx-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        num = Integer.parseInt(st[0]);
        idx = Integer.parseInt(st[1]);

        try {
            System.out.println(divisor(num, idx));
        } catch (Exception e) {
            System.out.println(0);
        }


        br.close();
    }
}
