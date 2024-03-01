package p5671;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input;
            while ((input = br.readLine()) != null) {
                Solution s = new Solution();
                Input ip = getInput(input);
                System.out.println(s.solution(ip.start, ip.end));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(String input) {
        String[] rawData = input.split(" ");
        int start = Integer.parseInt(rawData[0]);
        int end = Integer.parseInt(rawData[1]);
        return new Input(start, end);
    }
}

class Solution {

    public int solution(int start, int end) {
        int answer = 0;

        for (int i = start; i <= end; i++) {
            if(isValidRoomNumber(i)) answer++;
        }
        return answer;
    }

    private boolean isValidRoomNumber(int num) {
        int[] check = new int[10];

        while (num > 0) {
            check[num % 10] += 1;
            num /= 10;
        }
        for (int n : check) {
            if(n > 1) return false;
        }
        return true;
    }
}

class Input {

    int start;
    int end;

    public Input(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
