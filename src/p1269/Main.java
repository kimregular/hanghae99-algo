package p1269;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.set1, ip.set2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br ) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int set1Len = Integer.parseInt(st.nextToken());
        int set2Len = Integer.parseInt(st.nextToken());

        int[] set1 = getSet(br, set1Len);
        int[] set2 = getSet(br, set2Len);

        return new Input(set1, set2);
    }

    private static int[] getSet(BufferedReader br, int setLen) throws IOException {
        int[] set = new int[setLen];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < set.length; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }
        return set;
    }

    static class Input {

        int[] set1;
        int[] set2;

        public Input(int[] set1, int[] set2) {
            this.set1 = set1;
            this.set2 = set2;
        }
    }
}

class Solution {

    public int solution(int[] set1, int[] set2) {
        Set<Integer> differ1 = getDiffer(set1);
        Set<Integer> differ2 = getDiffer(set2);

        int answer = 0;

        answer += getNumOfExclusiveNums(differ1, set2);
        answer += getNumOfExclusiveNums(differ2, set1);

        return answer;
    }

    private Set<Integer> getDiffer(int[] set) {
        Set<Integer> differ = new HashSet<>();
        for (int i : set) {
            differ.add(i);
        }
        return differ;
    }

    private int getNumOfExclusiveNums(Set<Integer> set, int[] arr) {
        int result = 0;

        for (int i : arr) {
            if(!set.contains(i)) result++;
        }
        return result;
    }
}
