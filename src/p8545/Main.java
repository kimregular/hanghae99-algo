package p8545;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p8545/text.txt"));
        str = br.readLine().split("");

        Arrays.sort(str, Comparator.reverseOrder());

        System.out.println(String.join("", str));


        br.close();
    }
}
