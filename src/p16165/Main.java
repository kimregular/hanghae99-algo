package p16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.getGroups(), ip.getMemberOfGroup(), ip.getQuiz()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfGroups = Integer.parseInt(tokens[0]);
        int numOfQuiz = Integer.parseInt(tokens[1]);

        Map<String, List<String>> groups = getGroups(br, numOfGroups);
        Map<String, String> memberOfGroup = getMemberOfGroup(groups);
        List<List<String>> quiz = getQuiz(br, numOfQuiz);

        return new Input(groups, memberOfGroup,quiz);
    }

    private static Map<String, String> getMemberOfGroup(Map<String, List<String>> groups) {
        Map<String, String> memberOfGroup = new HashMap<>();
        for (String group : groups.keySet()) {
            List<String> members = groups.get(group);
            for (String member : members) {
                memberOfGroup.put(member, group);
            }
        }
        return memberOfGroup;
    }

    private static List<List<String>> getQuiz(BufferedReader br, int numOfQuiz) throws IOException {
        List<List<String>> quiz = new ArrayList<>();
        while(numOfQuiz --> 0) quiz.add(new ArrayList<>());
        for (int i = 0; i < quiz.size(); i++) {
            String name = br.readLine();
            String type = br.readLine();
            quiz.get(i).add(name);
            quiz.get(i).add(type);
        }
        return quiz;
    }

    private static Map<String, List<String>> getGroups(BufferedReader br, int numOfGroups) throws IOException {
        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < numOfGroups; i++) {
            String groupName = br.readLine();
            int len = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                members.add(br.readLine());
            }
            members.sort(null);
            groups.put(groupName, members);
        }
        return groups;
    }

    private static class Input {

        private final Map<String, List<String>> groups;
        private final Map<String, String> memberOfGroup;
        private final List<List<String>> quiz;

        public Input(Map<String, List<String>> groups, Map<String, String> memberOfGroup, List<List<String>> quiz) {
            this.groups = groups;
            this.memberOfGroup = memberOfGroup;
            this.quiz = quiz;
        }

        public Map<String, List<String>> getGroups() {
            return groups;
        }

        public Map<String, String> getMemberOfGroup() {
            return memberOfGroup;
        }

        public List<List<String>> getQuiz() {
            return quiz;
        }
    }
}

class Solution {

    public String solution(Map<String, List<String>> groups, Map<String, String> memberOfGroup, List<List<String>> quiz) {
        StringBuilder answer = new StringBuilder();

        for (List<String> q : quiz) {
            String target = q.get(0);
            String qType = q.get(1);

            answer.append(resolve(target, qType, groups, memberOfGroup)).append("\n");
        }
        return answer.toString();
    }

    private String resolve(String target, String qType, Map<String, List<String>> groups, Map<String, String> memberOfGroup) {
        StringBuilder result = new StringBuilder();

        if (qType.equals("0")) {
            List<String> members = groups.get(target);
            for (int i = 0; i < members.size(); i++) {
                result.append(members.get(i));
                if(i != members.size() - 1) result.append("\n");
            }
            return result.toString();
        } else {
            return memberOfGroup.get(target);
        }
    }
}