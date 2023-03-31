package p2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    static int num;

    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        for (Integer integer : set) {
            System.out.println(integer);
        }

        br.close();
    }
}
