package p2566;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> arr = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int raw;
    static int column;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2566/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr.add(new ArrayList<>());
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                arr.get(i).add(tmp);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (arr.get(i).get(j) > max) {
                    max = arr.get(i).get(j);
                    raw = i+1;
                    column = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(raw + " " + column);
        br.close();
    }
}
