package p2343;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfBlueray, ip.lectures));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        int numOfBlueray = Integer.parseInt(st.nextToken());

        int[] lectures = new int[len];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < lectures.length; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(numOfBlueray, lectures);
    }
}

class Solution {

    public int solution(int numOfBlueray, int[] lectures) {
        int answer = 0;

        int lp = getMax(lectures);
        int rp = getTotalLength(lectures);
        while (lp <= rp) {
            int mid = (lp + rp) / 2;

            if (getDiscNum(lectures, mid) <= numOfBlueray) {
                answer = mid;
                rp = mid - 1;
            } else {
                lp = mid + 1;
            }
        }
        return answer;
    }

    private int getDiscNum(int[] lectures, int capa) {
        int discNum = 1;
        int currentCapa = 0;
        for (int lecture : lectures) {
            if (currentCapa + lecture <= capa) {
                currentCapa += lecture;
            } else {
                discNum++;
                currentCapa = lecture;
            }
        }
        return discNum;
    }

    private int getMax(int[] lectures) {
        int max = 0;
        for(int lecture : lectures) if(max < lecture) max = lecture;
        return max;
    }

    private int getTotalLength(int[] lectures) {
        int totalLength = 0;
        for (int lecture : lectures) {
            totalLength += lecture;
        }
        return totalLength;
    }
}

class Input {

    int numOfBlueray;
    int[] lectures;

    public Input(int numOfBlueray, int[] lectures) {
        this.numOfBlueray = numOfBlueray;
        this.lectures = lectures;
    }
}