package p1389;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numOfPeople = Integer.parseInt(st.nextToken());
        int numOfRelations = Integer.parseInt(st.nextToken());

        int[][] peopleRelation = getIntArray(numOfPeople);

        for (int i = 0; i < numOfRelations; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            peopleRelation[from][to] = 1;
            peopleRelation[to][from] = 1;
        }

        return peopleRelation;
    }

    private static int[][] getIntArray(int n) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j) arr[i][j] = 0;
                else arr[i][j] = 10000;
            }
        }

        return arr;
    }
}

class Solution {

    public int solution(int[][] peopleRelation) {
        return getAnswer(FW(peopleRelation));
    }

    private int getAnswer(int[][] peopleRelation) {
        int answer = 0;
        int flag = Integer.MAX_VALUE;

        for (int i = 1; i < peopleRelation.length; i++) {
            int total = 0;
            for (int j = 1; j < peopleRelation[i].length; j++) {
                total += peopleRelation[i][j];
            }

            if (total < flag) {
                flag = total;
                answer = i;
            }
        }

        return answer;
    }

    private int[][] FW(int[][] peopleRelation) {

        for (int k = 1; k < peopleRelation.length; k++) {
            for (int i = 1; i < peopleRelation.length; i++) {
                for (int j = 1; j < peopleRelation.length; j++) {
                    peopleRelation[i][j] = Math.min(peopleRelation[i][j], peopleRelation[i][k] + peopleRelation[k][j]);
                }
            }
        }

        return peopleRelation;
    }
}
