package p11441;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.field, ip.sections));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        br.readLine();
        int[] field = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = Integer.parseInt(br.readLine());
        int[][] sections = new int[len][2];
        for (int i = 0; i < sections.length; i++) {
            sections[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return new Input(field, sections);
    }

    private static class Input {

        int[] field;
        int[][] sections;

        public Input(int[] field, int[][] sections) {
            this.field = field;
            this.sections = sections;
        }
    }
}

class Solution {

    StringBuilder answer = new StringBuilder();

    public String solution(int[] field, int[][] sections) {
        int[] accumulated = getAccumulated(field);
        for (int[] section : sections) {
            int start = section[0] - 1;
            int end = section[1];
            answer.append(accumulated[end] - accumulated[start]).append("\n");
        }
        return answer.toString();
    }

    private int[] getAccumulated(int[] field) {
        int[] result = new int[field.length + 1];
        result[0] = 0;
        int accumulatedNum = 0;
        for (int i = 1; i < result.length; i++) {
            accumulatedNum += field[i - 1];
            result[i] = accumulatedNum;
        }
        return result;
    }
}