package 완주못한선수;

import java.util.*;

public class NoFinishedAthlete {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana","mislav"};
        System.out.println(s.solution(participant, completion));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {

        ArrayList<String> noFinished = new ArrayList<>(Arrays.asList(participant));
        for (String s : completion) {
            noFinished.remove(s);
        }



        return noFinished.toString().replace('[', ' ').replace(']', ' ').trim();
    }
}