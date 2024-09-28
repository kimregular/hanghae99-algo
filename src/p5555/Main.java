package p5555;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.strs));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input readInput(BufferedReader br) throws IOException {
        String target = br.readLine();
        int len = Integer.parseInt(br.readLine());
        String[] strs = new String[len];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = br.readLine();
        }
        return new Input(target, strs);
    }

    private static class Input {

        private final String target;
        private final String[] strs;

        public Input(String target, String[] strs) {
            this.target = target;
            this.strs = strs;
        }

        public String getTarget() {
            return target;
        }

        public String[] getStrs() {
            return strs;
        }
    }
}

class Solution {

    public int solution(String target, String[] strs) {
        int result = 0;

        for (String str : strs) {
            str += str;
            if(str.contains(target)) result++;
        }
        return result;
    }
}