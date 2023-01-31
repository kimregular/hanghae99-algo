package 완주못한선수;

import java.util.*;

public class NoFinishedAthlete {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(s.solution(participant, completion));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        if (answer.length() == 0) {
            answer = participant[participant.length-1];
        }
        return answer;
    }
}

