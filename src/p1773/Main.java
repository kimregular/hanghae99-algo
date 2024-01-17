package p1773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfPeople = Integer.parseInt(st.nextToken());
            int showTime = Integer.parseInt(st.nextToken());

            int[] people = new int[numOfPeople];


            for (int i = 0; i < numOfPeople; i++) {
                people[i] = Integer.parseInt(br.readLine());
            }

            Solution s = new Solution(people, showTime);
            System.out.println(s.solution());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] people;
    int showTime;

    public Solution(int[] people, int showTime) {
        this.people = people;
        this.showTime = showTime;
    }

    public int solution() {
        boolean[] timeTable = new boolean[this.showTime + 1];
        int time = 0;

        for (int x : people) {
            for (int i = x; i <= this.showTime; i += x) {
                if(!timeTable[i]){
                    timeTable[i] = true;
                    time++;
                }

            }
        }
        return time;
    }
}