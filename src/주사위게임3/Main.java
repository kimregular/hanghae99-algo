package 주사위게임3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int a = 6;
        int b = 6;
        int c = 3;
        int d = 3;

        Solution s = new Solution();
        System.out.println(s.solution(a, b, c, d));
    }
}

class Solution {

    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new TreeMap<>();

        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        List<Integer> keyList = new ArrayList<>(map.keySet());

        if (map.size() == 1) {
            return fourInARow(a);
        }

        if (map.size() == 2) {
            return twoInARow(map, keyList);
        }

        if (map.size() == 3) {
            return threeInARow(map);
        }

        return oneInARow(map);
    }

    private int fourInARow(int a) {
        return 1111 * a;
    }

    private int twoInARow(Map<Integer, Integer> map, List<Integer> keyList) {
        int p = 0;
        int q = 0;

        if (map.get(keyList.get(0)) == 1 || map.get(keyList.get(0)) == 3) {
            p = map.get(keyList.get(0)) == 3 ? keyList.get(0) : keyList.get(1);
            q = map.get(keyList.get(0)) == 1 ? keyList.get(0) : keyList.get(1);

            return (int) Math.pow((10 * p) + q, 2);
        } else {
            p = keyList.get(0);
            q = keyList.get(1);

            return (p + q) * Math.abs(p - q);
        }
    }

    private int threeInARow(Map<Integer, Integer> map) {
        int[] keys = new int[2];
        int idx = 0;

        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
            if (elem.getValue() == 1) {
                keys[idx++] = elem.getKey();
            }
        }

        return keys[0] * keys[1];
    }

    private int oneInARow(Map<Integer, Integer> map) {
        int input = 0;
        for (Integer i : map.keySet()) {
            input = i;
            break;
        }

        return input;
    }
}
