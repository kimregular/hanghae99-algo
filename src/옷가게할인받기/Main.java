package 옷가게할인받기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int price = 150000;
        System.out.println(s.solution(price));
    }
}


class Solution {
    public int solution(int price) {
        double rate = (price >= 500_000) ? 0.2 : (price >= 300_000 ? 0.1 : 0.05);
        if (price < 100_000) {
            rate = 0;
        }
        return (int)(price - (price * rate));
    }
}