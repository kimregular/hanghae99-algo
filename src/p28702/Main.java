package p28702;

import java.io.*;

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
        String[] result = new String[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public String solution(String[] input) {
        int target = 0;

        for (int i = 0; i < input.length; i++) {
            try{
                target = Integer.parseInt(input[i]);
                return getAnswer(target, i);
            }catch(Exception ignored){

            }
        }
        return "Never come here plzzzzz";
    }

    private String getAnswer(int target, int idx) {
        target += 3 - idx;

        if(target % 3 == 0 && target % 5 == 0) return "FizzBuzz";
        if(target % 3 == 0) return "Fizz";
        if(target % 5 == 0) return "Buzz";
        return "" + target;
    }
}