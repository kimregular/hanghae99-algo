package 최댓값과최솟값;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "1 2 3 4";
        System.out.println(s.solution(str));
    }
}

class Solution {
    public String solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String n : s.split(" ")) {
            arr.add(Integer.parseInt(n));
        }
        arr.sort(Comparator.naturalOrder());
        StringBuilder answer = new StringBuilder();
        answer.append(arr.get(0)).append(" ").append(arr.get(arr.size() - 1));
        return answer.toString();
    }
}