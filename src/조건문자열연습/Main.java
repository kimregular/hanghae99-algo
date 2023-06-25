package 조건문자열연습;


public class Main {
    public static void main(String[] args) {
        String ineq = "<";
        String eq = "=";

        int n = 20;
        int m = 50;

        Operator oper = OperFactory.createOper(ineq, eq);
        Solution s = new Solution(oper);

        System.out.println(s.compare(n, m));
    }
}


interface Operator {
    boolean compare(int n, int m);
}

class LessThanOper implements Operator {
    @Override
    public boolean compare(int n, int m) {
        return n < m;
    }
}

class LessThanOrEqualOper implements Operator {
    @Override
    public boolean compare(int n, int m) {
        return n <= m;
    }
}

class GreaterThanOper implements Operator {
    @Override
    public boolean compare(int n, int m) {
        return n > m;
    }
}

class GreaterThanOrEqualOper implements Operator {
    @Override
    public boolean compare(int n, int m) {
        return n >= m;
    }
}

class OperFactory {
    public static Operator createOper(String ineq, String eq) {
        if (ineq.equals("<")) {
            return eq.equals("=") ? new LessThanOrEqualOper() : new LessThanOper();
        }
        return eq.equals("=") ? new GreaterThanOrEqualOper() : new GreaterThanOper();
    }
}

class Solution {
    private final Operator operator;

    public Solution(Operator operator) {
        this.operator = operator;
    }

    public int compare(int n, int m) {
        return operator.compare(n, m) ? 1 : 0;
    }
}