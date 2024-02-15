package p6321;

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
        int TEST_CASE = Integer.parseInt(br.readLine());

        String[] inputs = new String[TEST_CASE];

        for (int i = 0; i < TEST_CASE; i++) {
            inputs[i] = br.readLine();
        }

        return inputs;
    }
}

class Solution {

    public String solution(String[] inputs) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < inputs.length; i++) {
            answer.append("String #").append(i + 1).append("\n");
            answer.append(getRealName(inputs[i])).append("\n").append("\n");
        }

        return answer.toString();
    }

    public String getRealName(String name) {
        StringBuilder realName = new StringBuilder();
        for (char c : name.toCharArray()) {
            char newSpell = (char) (c + 1);

            if(newSpell > 'Z') realName.append('A');
            else realName.append(newSpell);
        }

        return realName.toString();
    }
}
