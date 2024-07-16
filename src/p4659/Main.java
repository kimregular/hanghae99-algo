package p4659;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getInput(BufferedReader br) throws IOException {
        List<String> result = new ArrayList<>();
        String input = "";

        while (!(input = br.readLine()).equals("end")) {
            result.add(input);
        }
        return result;
    }
}

class Solution {

    public String solution(List<String> passwords) {
        StringBuilder result = new StringBuilder();

        for (String password : passwords) {
            result.append("<").append(password).append("> is ");
            if (isValid(password)) {
                result.append("acceptable.");
            } else {
                result.append("not acceptable.");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private boolean isValid(String password) {
        return conditionOne(password) && conditionTwo(password) && conditionThree(password);
    }

    private boolean conditionOne(String password) {
        return containsAny(password, "a", "e", "i", "o", "u");
    }

    private boolean conditionTwo(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String tempTarget = password.substring(i, i + 3);
            if (!containsAny(tempTarget, "a", "e", "i", "o", "u")) {
                return false;
            }
            if (containsAll(tempTarget, "a", "e", "i", "o", "u")) {
                return false;
            }
        }
        return true;
    }

    private boolean conditionThree(String password) {
        if(password.length() == 1) return true;

        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                if (password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean containsAny(String target, String... compare) {
        for (String c : compare) {
            if (target.contains(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsAll(String target, String... compare) {
        boolean[] result = new boolean[target.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = containsAny(String.valueOf(target.charAt(i)), compare);
        }
        for (boolean r : result) {
            if(!r) return false;
        }
        return true;
    }
}