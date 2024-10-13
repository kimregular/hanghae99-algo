package p30676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int range) {
        String result;

        if (range >= 620) {
            result = "Red";
        } else if (range >= 590) {
            result = "Orange";
        } else if (range >= 570) {
            result = "Yellow";
        } else if (range >= 495) {
            result = "Green";
        } else if (range >= 450) {
            result = "Blue";
        } else if (range >= 425) {
            result = "Indigo";
        } else {
            result = "Violet";
        }
        return result;
    }
}