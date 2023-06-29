package 간단한식계산하기연습;


public class Main {
    public static void main(String[] args) {

        String str = "40000 * 40000";
        String[] inputs = str.split(" ");

        int num1 = Integer.parseInt(inputs[0]);
        String oper = inputs[1];
        int num2 = Integer.parseInt(inputs[2]);

        Operator operator = OperFactory.createOper(oper);
        Solution s = new Solution(operator);
        System.out.println(s.solution(num1 , num2));

    }
}

class Solution {

    private final Operator operator;

    public Solution(Operator operator) {
        this.operator = operator;
    }

    public int solution(int num1, int num2) {
        return operator.Calc(num1, num2);
    }
}

interface Operator {
    int Calc(int num1, int num2);
}

class CalcPlus implements Operator {
    @Override
    public int Calc(int num1, int num2) {
        return num1 + num2;
    }
}

class CalcMinus implements Operator {
    @Override
    public int Calc(int num1, int num2) {
        return num1 - num2;
    }
}

class CalcMulti implements Operator {
    @Override
    public int Calc(int num1, int num2) {
        return num1 * num2;
    }
}

class OperFactory {
    public static Operator createOper(String oper) {
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

