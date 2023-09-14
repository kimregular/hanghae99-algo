package p2985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            FormulaFinder ff = new FormulaFinder(a, b, c);
            System.out.println(ff.getFormula());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class FormulaFinder {

    int a;
    int b;
    int c;

    public FormulaFinder(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getFormula() {
        String op = findOperator(a, b, c);

        if (op.isEmpty()) {
            op = findBackwardsOperator(a, b, c);
            return a + "=" + b + op + c;
        }

        return a + op + b + "=" + c;
    }

    private String findOperator(int a, int b, int c) {
        if (a + b == c) {
            return "+";
        }
        if (a - b == c) {
            return "-";
        }
        if (a * b == c) {
            return "*";
        }
        if (a / b == c) {
            return "/";
        }

        return "";
    }

    private String findBackwardsOperator(int a, int b, int c) {
        if (a == b + c) {
            return "+";
        }
        if (a == b - c) {
            return "-";
        }
        if (a == b * c) {
            return "*";
        }

        return "/";
    }
}