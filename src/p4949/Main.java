package p4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder answer = new StringBuilder();
            while (true) {
                String input = br.readLine();

                if (input.equals(".")) {
                    break;
                }

                BracketValidator bv = new BracketValidator(input);
                answer.append(bv.validateBracket()).append("\n");
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class BracketValidator {

    String input;

    Stack<Character> bracketStk = new Stack<>();


    public BracketValidator(String input) {
        this.input = input;
    }

    public String validateBracket() {

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[') {
                bracketStk.push(ch);
            } else if (ch == ')') {

                if (bracketStk.isEmpty() || bracketStk.peek() != '(') {
                    return "no";
                } else {
                    bracketStk.pop();
                }

            } else if (ch == ']') {

                if (bracketStk.isEmpty() || bracketStk.peek() != '[') {
                    return "no";
                } else {
                    bracketStk.pop();
                }

            }
        }

        if(bracketStk.isEmpty()) return "yes";
        return "no";
    }
}

