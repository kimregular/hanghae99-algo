package 전국대회선발고사;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] rank = {3, 7, 2, 5, 4, 6, 1};
        boolean[] attendace = {false, true, true, true, true, false, false};

        Solution s = new Solution();
        System.out.println(s.solution(rank, attendace));

    }
}

class Solution {

    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            map.put(rank[i], i);
        }
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                lst.add(rank[i]);
            }
        }

        lst.sort(Comparator.naturalOrder());

        for (int i = 0; i < 3; i++) {
            answer += getResult(map.getOrDefault(lst.get(i), 0), i);
        }


        return answer;
    }

    private int getResult(int rank, int cnt) {
        if (cnt == 0) {
            return 10000 * rank;
        }

        if (cnt == 1) {
            return 100 * rank;
        }

        if (cnt == 2) {
            return rank;
        }

        return -1;
    }
}
