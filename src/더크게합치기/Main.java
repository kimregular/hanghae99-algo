package 더크게합치기;

public class Main {
    public static void main(String[] args) {

        int num1 = 9;
        int num2 = 91;

        Solution s = new Solution();
        System.out.println(s.solution(num1 , num2));

    }
}

class Solution {

    public int solution(int num1, int num2) {
        int result1 = Integer.parseInt(getNum(num1, num2));
        int result2 = Integer.parseInt(getNum(num2, num1));


        if (isBigger(result1, result2)) {
            return result1;
        } else {
            return result2;
        }
    }

    private String getNum(int num1, int num2) {
        String tmp1 = String.valueOf(num1);
        String tmp2 = String.valueOf(num2);

        return tmp1 + tmp2;
    }

    private boolean isBigger(int num1, int num2) {
        return num1 >= num2;
    }
}
