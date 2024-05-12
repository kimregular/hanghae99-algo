package p31831;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.threshold, ip.stressList));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int threshold = Integer.parseInt(tokens[1]);

        int[] stressList = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < stressList.length; i++) {
            stressList[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(threshold, stressList);
    }

    private static class Input{
        int threshold;
        int[] stressList;

        public Input(int threshold, int[] stressList) {
            this.threshold = threshold;
            this.stressList = stressList;
        }
    }
}

class Solution {

    public int solution(int threshold, int[] stressList) {
        StressDealer sangwon = new StressDealer(threshold);
        int cnt = 0;
        for (int i : stressList) {
            sangwon.setStressIndex(i);
            if(sangwon.getThreshold() <= sangwon.getStressIndex()) cnt++;
        }

        return cnt;
    }
}

class StressDealer {

    int threshold;

    int stressIndex = 0;

    public StressDealer(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }


    public int getStressIndex() {
        return stressIndex;
    }

    public void setStressIndex(int stressIndex) {
        this.stressIndex += stressIndex;
        if(this.stressIndex < 0) this.stressIndex = 0;
    }
}