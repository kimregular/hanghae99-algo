package 숨어있는숫자의덧셈;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "aAb1B2cC34oOp";
        System.out.println(s.solution(my_string));
    }
}


class Solution {
    public int solution(String my_string) {
        my_string += "a";
        int answer = 0;
        ArrayList<Integer> stck = new ArrayList<>();
        for (String str : my_string.split("")) {
            try {
                int tmp = Integer.parseInt(str);
                stck.add(tmp);
            } catch (NumberFormatException e) {
                if (stck.size() > 0) {
                    answer += oneInt(stck);
                }
                stck.clear();
            }
        }
        return answer;
    }

    public int oneInt(List<Integer> lst) {
        int total = 0;
        for (int num : lst) {
            total *= 10;
            total += num;
        }
        return total;
    }
}