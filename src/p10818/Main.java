package p10818;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int num;
    static TreeSet<Integer> tree = new TreeSet<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10818/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            tree.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(tree.first() + " " + tree.last());
        br.close();
    }
}
