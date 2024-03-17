package p2776;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Input ip = getInput(br);
                Solution s = new Solution();
                System.out.println(s.solution(ip.note1, ip.note2));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len1 = Integer.parseInt(br.readLine());
        int[] note1 = new int[len1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < note1.length; i++) {
            note1[i] = Integer.parseInt(st.nextToken());
        }

        int len2 = Integer.parseInt(br.readLine());
        int[] note2 = new int[len2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < note2.length; i++) {
            note2[i] = Integer.parseInt(st.nextToken());
        }

        return new Input(note1, note2);
    }

    static class Input{

        int[] note1;
        int[] note2;

        public Input(int[] note1, int[] note2) {
            this.note1 = note1;
            this.note2 = note2;
        }
    }
}

class Solution {

    public String solution(int[] note1, int[] note2) {
        StringBuilder answer = new StringBuilder();
        Set<Integer> note1Map = new HashSet<>();
        for(int i : note1) note1Map.add(i);
        for (int i = 0; i < note2.length; i++) {
            if (note1Map.contains(note2[i])) {
                answer.append(1);
            } else {
                answer.append(0);
            }
            if(i != note2.length - 1) answer.append("\n");
        }
        return answer.toString();
    }
}
