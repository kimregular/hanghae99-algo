package p13414;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.limit, ip.studentIdList));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int limit = Integer.parseInt(tokens[0]);
        int len = Integer.parseInt(tokens[1]);

        String[] studentIdList = new String[len];
        for (int i = 0; i < studentIdList.length; i++) {
            studentIdList[i] = br.readLine();
        }
        return new Input(limit, studentIdList);
    }

    private static class Input{
        int limit;
        String[] studentIdList;

        public Input(int limit, String[] studentIdList) {
            this.limit = limit;
            this.studentIdList = studentIdList;
        }
    }
}

class Solution{

    public String solution(int limit, String[] studentIdList) {
        LinkedHashSet<String> line = new LinkedHashSet<>();

        for (String studentId : studentIdList) {
            if(line.contains(studentId)) line.remove(studentId);
            line.add(studentId);
        }


        return getAnswer(line, limit);
    }

    private String getAnswer(LinkedHashSet<String> line, int limit) {
        StringBuilder answer = new StringBuilder();

        int num = 0;
        for (String next : line) {
            if(num == limit) break;
            answer.append(next).append("\n");
            num++;
        }

        return answer.toString();
    }
}