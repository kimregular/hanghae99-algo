package p10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] razer = br.readLine().toCharArray();

            SteelCutter sc = new SteelCutter(razer);
            System.out.println(sc.cutSteel());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class SteelCutter {

    char[] razer;

    public SteelCutter(char[] razer) {
        this.razer = razer;
    }

    public int cutSteel() {
        Stack<Character> stk = new Stack<>();
        int numOfSteelPiece = 0;
        boolean isSteel = false;

        for (char ch : razer) {
            if (ch == '(') {
                stk.add(ch);
                isSteel = true;
            } else {
                if (isSteel) {
                    numOfSteelPiece += stk.size() - 1;
                    isSteel = false;
                } else {
                    numOfSteelPiece += 1;
                }
                stk.pop();
            }
        }

        return numOfSteelPiece;
    }
}