package p2752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tr = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> arr = new ArrayList<>();
        while (tr.hasMoreTokens()) {
            arr.add(Integer.parseInt(tr.nextToken()));
        }

        arr.sort(Comparator.naturalOrder());
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
