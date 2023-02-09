package 외계어사전;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        System.out.println(s.solution(spell, dic));
    }
}


class Solution {
    public int solution(String[] spell, String[] dic) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (String str : dic) {

            for (String s : str.split("")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            for (String sp : spell) {
                if (map.containsKey(sp)) {
                    map.put(sp, map.get(sp) - 1);
                } else {
                    map.put(sp, map.getOrDefault(sp, 0) + 1);
                }
            }
            for (int num : map.values()) {
                answer += num;
            }
            if (answer == 0) {
                return 1;
            }
            map.clear();
            answer = 0;
        }
        return 2;
    }

}