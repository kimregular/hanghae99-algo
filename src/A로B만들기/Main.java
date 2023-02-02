package A로B만들기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String before = "olleh";
        String after = "hello";
        System.out.println(s.solution(before, after));

    }
}


//class Solution {
//    public int solution(String before, String after) {
//        int answer = 0;
//        Map<String, Integer> map = new HashMap<>();
//        for (String str : before.split("")) {
//            map.put(str, map.getOrDefault(str, 0) + 1);
//        }
//        for (String str : after.split("")) {
//            map.put(str, map.getOrDefault(str, 0) - 1);
//            if (map.get(str) == 0) {
//                map.remove(str);
//            }
//        }
//        for (int cnt : map.values()) {
//            if (cnt > 0) {
//                return answer;
//            }
//        }
//        answer = 1;
//        return answer;
//    }
//}

class Solution {
    public int solution(String before, String after) {
        char[] a = before.toCharArray();
        char[] b = after.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b)) ? 1 : 0;
    }
}