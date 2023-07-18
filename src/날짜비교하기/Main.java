package 날짜비교하기;

public class Main {
    public static void main(String[] args) {

        int[] date1 = {2010, 2, 10};
        int[] date2 = {2009, 12, 10};

        Solution s = new Solution();
        System.out.println(s.solution(date1, date2));

    }
}


class Solution{

    public int solution(int[] date1, int[] date2) {

        int year = date1[0] - date2[0];
        int mon = date1[1] - date2[1];
        int day = date1[2] - date2[2];

        if (year < 0) {
            return 1;
        } else if (year >= 1) {
            return 0;
        }

        if (mon < 0) {
            return 1;
        } else if (mon >= 1) {
            return 0;
        }

        if (day < 0) {
            return 1;
        } else if (day >= 1) {
            return 0;
        }

        return 0;
    }
}