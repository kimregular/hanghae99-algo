package p9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        String ip = "";
        while((ip= br.readLine())!=null ) {
            result.add(ip);
        }
        return result;
    }
}

class Solution {

    public String solution(List<String> inputs) {
        StringBuilder result = new StringBuilder();

        for (String input : inputs) {
            Target t = getTarget(input);

            result.append(input).append(" = ");
            if (isExceedingRange(t)) {
                result.append("No permutation");
            } else {
                PermutationResolver pr = new PermutationResolver(t);
                result.append(pr.getResult());
            }
            result.append("\n");
        }
        return result.toString();
    }

    private boolean isExceedingRange(Target target) {
        int range = 1;
        for (int i = 2; i <= target.str.length(); i++) {
            range *= i;
        }
        return range < target.idx;
    }

    private Target getTarget(String input) {
        String[] temp = input.split(" ");
        String str = temp[0];
        int idx = Integer.parseInt(temp[1]);
        return new Target(str, idx);
    }

    private class Target {

        String str;
        int idx;

        public Target(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    private static class PermutationResolver {

        String str;
        int idx;
        int compareIdx = 0;
        char[] permutated;
        boolean[] isUsed;
        String result = "";

        public PermutationResolver(Target t) {
            this.str = t.str;
            this.idx = t.idx;
            this.permutated = new char[str.length()];
            this.isUsed = new boolean[str.length()];
        }

        public String getResult() {
            permutate(0);
            return result;
        }

        private void permutate(int cnt) {
            if (cnt == str.length()) {
                compareIdx++;
                if (compareIdx == idx) {
                    result = convert(permutated);
                    return;
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if(isUsed[i]) continue;

                isUsed[i] = true;
                permutated[cnt] = str.charAt(i);
                permutate(cnt + 1);
                isUsed[i] = false;
            }
        }

        private String convert(char[] target) {
            StringBuilder result = new StringBuilder();
            for (char c : target) {
                if(c == '\u0000') continue;
                result.append(c);
            }
            return result.toString();
        }

    }
}