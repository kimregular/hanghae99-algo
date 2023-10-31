package p4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        StringBuilder answer = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();

                if (input.equals(".")) {
                    break;
                }

                BracketValidator bv = new BracketValidator(input);
                answer.append(bv.validateBracket()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(answer);
    }
}

class BracketValidator {

    String input;

    public BracketValidator(String input) {
        this.input = input;
    }

    public String validateBracket() {
        ArrayList<Character> bArr = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[') bArr.add(ch);


            else if (ch == ')') {
                if (bArr.isEmpty()) return "NO";
                if (bArr.get(bArr.size() - 1) != '(') return "NO";
                bArr.remove(bArr.size() - 1);
            } else if (ch == ']') {
                if (bArr.isEmpty()) return "NO";
                if (bArr.get(bArr.size() - 1) != '[') return "NO";
                bArr.remove(bArr.size() - 1);
            }
        }

        if (bArr.isEmpty()) return "YES";
        return "NO";
    }
}

