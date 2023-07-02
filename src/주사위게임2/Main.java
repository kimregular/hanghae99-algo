package 주사위게임2;

/**
 * 주사위 게임 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181930
 */
public class Main {
    public static void main(String[] args) {

        int a = 4;
        int b = 4;
        int c = 4;

        Solution s = new Solution();
        System.out.println(s.solution(a, b, c));
    }
}

class Solution {


    public int solution(int a, int b, int c) {
        Calculator calc = CalcFactory.getCalc(a, b, c);
        return calc.calc(a, b, c);
    }

}

interface Calculator {
    public int calc(int a, int b, int c);
}

class AllSame implements Calculator {
    @Override
    public int calc(int a, int b, int c) {
        return (a + b + c) * ((a*a) + (b*b) + (c*c)) *((a*a*a) + (b*b*b) + (c*c*c));
    }
}

class TwoSame implements Calculator {
    @Override
    public int calc(int a, int b, int c) {
        return (a + b + c) * ((a*a) + (b*b)+ (c*c));
    }
}

class NotSame implements Calculator {
    @Override
    public int calc(int a, int b, int c) {
        return a + b + c;
    }
}

class CalcFactory {

    public static Calculator getCalc(int a, int b, int c) {
        if (a == b && b == c) {
            return new AllSame();
        } else if (a == b || a == c || b == c) {
            return new TwoSame();
        } else {
            return new NotSame();
        }
    }
}