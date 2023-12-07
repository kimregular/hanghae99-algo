package p6996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                AnagramMaker am = new AnagramMaker(str1, str2);
                System.out.println(am.isAnagram());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class AnagramMaker {

    String str1;
    String str2;

    public AnagramMaker(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String isAnagram() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : str1.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : str2.split("")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) - 1);
            } else {
                return this.str1 +  " & " + this.str2 +  " are NOT anagrams.";
            }
        }

        for (Integer value : map.values()) {
            if(value != 0) return this.str1 +  " & " + this.str2 +  " are NOT anagrams.";
        }

        return this.str1 +  " & " + this.str2 +  " are anagrams.";
    }
}