package p4158;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String[] numOfCDs = br.readLine().split(" ");
                int numOfCD1 = Integer.parseInt(numOfCDs[0]);
                int numOfCD2 = Integer.parseInt(numOfCDs[1]);

                if (numOfCD1 == 0 && numOfCD2 == 0) {
                    break;
                }

                Input ip = getInput(br, numOfCD1, numOfCD2);
                Solution s = new Solution();
                System.out.println(s.solution(ip.cd1, ip.cd2));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br, int numOfCD1, int numOfCD2) throws IOException {
        int[] cd1 = new int[numOfCD1];
        int[] cd2 = new int[numOfCD2];

        for (int i = 0; i < cd1.length; i++) {
            cd1[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < cd2.length; i++) {
            cd2[i] = Integer.parseInt(br.readLine());
        }

        return new Input(cd1, cd2);
    }
}

class Solution {

    public int solution(int[] cd1, int[] cd2) {
        int result = 0;

        HashSet<Integer> cdList = getCDList(cd1);

        for (int i : cd2) {
            if (cdList.contains(i)) {
                result++;
            }
        }

        return result;
    }

    private HashSet<Integer> getCDList(int[] cd) {
        HashSet<Integer> cdList = new HashSet<>();

        for (int i : cd) {
            cdList.add(i);
        }
        return cdList;
    }
}

class Input {

    int[] cd1;
    int[] cd2;

    public Input(int[] cd1, int[] cd2) {
        this.cd1 = cd1;
        this.cd2 = cd2;
    }
}
