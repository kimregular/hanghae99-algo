package p17219;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.field, ip.target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int targetLen = Integer.parseInt(tokens[1]);

        String[] field = new String[len];
        for (int i = 0; i < field.length; i++) {
            field[i] = br.readLine();
        }

        String[] target = new String[targetLen];
        for (int i = 0; i < target.length; i++) {
            target[i] = br.readLine();
        }

        return new Input(field, target);
    }

    private static class Input{

        String[] field;
        String[] target;

        public Input(String[] field, String[] target) {
            this.field = field;
            this.target = target;
        }
    }
}

class Solution{

    public String solution(String[] field, String[] targets) {
        Map<String, String> accountInfo = new HashMap<>();

        for (String info : field) {
            String[] account = info.split(" ");
            String page = account[0];
            String password = account[1];

            accountInfo.put(page, password);
        }

        StringBuilder answer = new StringBuilder();
        for (String target : targets) {
            answer.append(accountInfo.get(target)).append("\n");
        }
        return answer.toString();
    }
}