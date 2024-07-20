package p25192;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public int solution(String[] people) {
        int result = 0;

        HashSet<String> sayHi = new HashSet<>();
        for (String person : people) {
            if ("ENTER".equals(person)) {
                result += sayHi.size();
                sayHi = new HashSet<>();
            } else {
                sayHi.add(person);
            }
        }
        result += sayHi.size();
        return result;
    }
}
