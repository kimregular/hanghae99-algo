package p5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static String[] st;

    static int tmp = 0;
    // test

    static int time = 0;
    static List<List<String>> lst = List.of(
            List.of("A", "B", "C"),
            List.of("D", "E", "F"),
            List.of("G", "H", "I"),
            List.of("J", "K", "L"),
            List.of("M", "N", "O"),
            List.of("P", "Q", "R", "S"),
            List.of("T", "U", "V"),
            List.of("W", "X", "Y", "Z")
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split("");


        for (String s : st) {
            for (List<String> strings : lst) {
                if (strings.contains(s)) {
                    tmp = lst.indexOf(strings) + 3;
                    time += tmp;
                }
            }
        }

        System.out.println(time);


        br.close();
    }
}
