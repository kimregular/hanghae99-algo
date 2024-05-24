package p9316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution{

    public String solution(int repeatNum) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeatNum; i++) {
            result.append("Hello World, Judge ").append(i + 1).append("!").append("\n");
        }
        return result.toString();
    }
}