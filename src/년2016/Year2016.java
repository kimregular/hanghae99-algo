package 년2016;

public class Year2016 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 5;
        int b = 24;
        System.out.println(s.solution(a, b));
    }
}

class Solution {
    public String solution(int a, int b) {
        int[] dates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekdays = { "THU", "FRI", "SAT","SUN", "MON", "TUE", "WED",};
        int days = 0;
        for (int i = 0; i < a - 1; i++) {
            days += dates[i];
        }
        days += b;
        System.out.println(days);
        System.out.println(days%7);
        return weekdays[days%7];
    }
}

