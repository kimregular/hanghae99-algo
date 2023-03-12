package p3052;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p3052/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            int num = Integer.parseInt(str) % 42;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map.size());



        br.close();
    }
}
