package p10546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.getRunners(), ip.getCompleted()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        String[] runners = new String[len];
        for (int i = 0; i < runners.length; i++) {
            runners[i] = br.readLine();
        }

        String[] completed = new String[len - 1];
        for (int i = 0; i < completed.length; i++) {
            completed[i] = br.readLine();
        }

        return new Input(runners, completed);
    }

    private static class Input {

        private final String[] runners;
        private final String[] completed;

        public Input(String[] runners, String[] completed) {
            this.runners = runners;
            this.completed = completed;
        }

        public String[] getRunners() {
            return runners;
        }

        public String[] getCompleted() {
            return completed;
        }
    }
}

class Solution {

    public String solution(String[] runners, String[] completed) {
        Map<String, Integer> incompleted = getMap(runners);

        for (String done : completed) {
            Integer isDone = incompleted.get(done);
            if(isDone == 1) incompleted.remove(done);
            else incompleted.put(done, isDone - 1);
        }

        String answer = "";
        for (String result : incompleted.keySet()) {
            answer = result;
        }

        return answer;
    }

    private Map<String, Integer> getMap(String[] runners) {
        Map<String, Integer> result = new HashMap<>();
        for (String runner : runners) {
            result.put(runner, result.getOrDefault(runner, 0) + 1);
        }
        return result;
    }
}