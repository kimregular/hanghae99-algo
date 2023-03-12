package p1157;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static HashMap<String, Integer> map = new HashMap<>();
    static int MAX_NUM = Integer.MIN_VALUE;

    static String result;



    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1157/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("");
        for (String s : st) {
            s = s.toUpperCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() == MAX_NUM) {
                result = "?";
            }else if (stringIntegerEntry.getValue() > MAX_NUM) {
                MAX_NUM = stringIntegerEntry.getValue();
                result = stringIntegerEntry.getKey();
            }

        }

        System.out.println(result);

        br.close();
    }
}
