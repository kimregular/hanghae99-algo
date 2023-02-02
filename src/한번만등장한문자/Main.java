package 한번만등장한문자;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abdc";
        System.out.println(s.solution(str));

    }
}


class Solution {
    public String solution(String str) {
        StringBuilder tmp = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (String letter : str.split("")) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() == 1) {
                tmp.append(pair.getKey());
            }
        }
        String[] answer = tmp.toString().split("");
        Arrays.sort(answer);

        return String.join("", answer);
    }
}