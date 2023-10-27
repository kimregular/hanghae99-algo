package p17413;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();

            StringReverser sr = new StringReverser(str);
            System.out.println(sr.reverseString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class StringReverser {

    String str;
    StringBuilder answer = new StringBuilder();

    public StringReverser(String str) {
        this.str = str;
    }

    public String reverseString() {
        StringBuilder angleBracket = new StringBuilder();
        boolean angleFlag = false;
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (angleFlag) {
                angleBracket.append(ch);
                if (ch == '>') {
                    angleFlag = false;
                    answer.append(angleBracket);
                    angleBracket.setLength(0);
                }
            } else {
                if (ch == '<') {
                    reverseStk(stk);
                    angleBracket.append(ch);
                    angleFlag = true;
                } else {
                    if (ch == ' ') {
                        reverseStk(stk);
                        answer.append(ch);
                    } else {
                        stk.add(ch);
                    }
                }
            }
        }
        if (!stk.isEmpty()) {
            reverseStk(stk);
        }

        return answer.toString();
    }

    private void reverseStk(Stack<Character> stk) {
        while (!stk.isEmpty()) {
            char tmp = stk.pop();
            if (tmp == ' ') {
                answer.append(" ");
            } else {
                answer.append(tmp);
            }
        }

    }
}