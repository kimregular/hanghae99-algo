package 부족한금액;

public class InsufficientAmount {
    public static void main(String[] args) {
        Solution s = new Solution();
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(s.solution(price, money, count));
    }
}

class Solution {
    public long solution(long price, long money, long count) {
        long tmp = price;
        for (int i = 2; i <= count; i++) {
            price += tmp * i;
        }
        if (price - money < 0) {
            return 0;
        }
        return price - money;
    }
}