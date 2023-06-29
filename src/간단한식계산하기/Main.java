package 간단한식계산하기;


public class Main {
    public static void main(String[] args) {

        String str = "43 + 12";

        Solution s = new Solution();
        System.out.println(s.solution(str));


    }
}

class Solution {

    public int solution(String str) {
        String[] inputs = str.split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[2]);
        String operator = inputs[1];

        Calculator calc = CalcFactory.createCalc(operator);

        return calc.calc(num1, num2);
    }



    interface Calculator {
        int calc(int num1, int num2);
    }

     static class CalcPlus implements Calculator {
        @Override
        public int calc(int num1, int num2) {
            return num1 + num2;
        }
    }

     static class CalcMinus implements Calculator {
        @Override
        public int calc(int num1, int num2) {
            return num1 - num2;
        }
    }

    static class CalcMulti implements Calculator {
        @Override
        public int calc(int num1, int num2) {
            return num1 * num2;
        }
    }

     static class CalcFactory {
        public static Calculator createCalc(String oper) {
            switch (oper) {
                case "+" :
                    return new CalcPlus();
                case "-":
                    return new CalcMinus();
                default:
                    return new CalcMulti();
            }
        }
    }
}
