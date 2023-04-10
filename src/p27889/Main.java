package p27889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> map = new HashMap<>();
    static String word;

    public static void main(String[] args) throws IOException {
        map.put("NLCS", "North London Collegiate School");
        map.put("BHA", "Branksome Hall Asia");
        map.put("KIS", "Korea International School");
        map.put("SJA", "St. Johnsbury Academy");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();

        System.out.println(map.get(word));

        br.close();
    }
}
