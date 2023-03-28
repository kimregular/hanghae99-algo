package p2738;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int row;

    static int column;

    static StringTokenizer st;

    static List<List<Integer>> arr1 = new ArrayList<>();
    static List<List<Integer>> arr2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2738/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndCol = br.readLine().split(" ");
        row = Integer.parseInt(rowAndCol[0]);
        column = Integer.parseInt(rowAndCol[1]);

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            arr1.add(new ArrayList<>());
            while (st.hasMoreTokens()) {
                arr1.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            arr2.add(new ArrayList<>());
            while (st.hasMoreTokens()) {
                arr2.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr1.get(i).size(); j++) {
                int tmp = arr1.get(i).get(j) + arr2.get(i).get(j);
                System.out.print(tmp + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
