package 수조작하기1;

public class Main {
    public static void main(String[] args) {

        int n = 0;
        String orders = "wsdawsdassw";

        Solution s = new Solution();
        System.out.println(s.solution(n, orders));

    }
}

class Solution {

    public int solution(int n, String orders) {
        for (int i = 0; i < orders.length(); i++) {
            char tmp = orders.charAt(i);
            switch (tmp) {
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}
