package p26069;

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

    private static String[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[][] people = new String[len][2];

        for (int i = 0; i < people.length; i++) {
            people[i] = br.readLine().split(" ");
        }
        return people;
    }
}

class Solution {

    Set<String> dancingPeople = new HashSet<>(Set.of("ChongChong"));

    public int solution(String[][] people) {
        for (String[] targets : people) {
            String target1 = targets[0];
            String target2 = targets[1];

            if (dancingPeople.contains(target1) || dancingPeople.contains(target2)) {
                dancingPeople.add(target1);
                dancingPeople.add(target2);
            }
        }
        return dancingPeople.size();
    }
}