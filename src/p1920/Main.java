package p1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    static int arrLen;
    static String[] arr;

    static int num;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/p1920/text.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrLen = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        num = Integer.parseInt(br.readLine());
        map = new LinkedHashMap<>();
        String[] tmp = br.readLine().split(" ");
        for (String s : tmp) {
            map.put(s, 0);
        }

        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
        }
        for (Integer value : map.values()) {
            System.out.println(value);
        }


        br.close();
    }
}
